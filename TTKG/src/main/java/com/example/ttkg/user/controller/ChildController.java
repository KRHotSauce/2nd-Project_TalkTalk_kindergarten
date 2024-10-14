package com.example.ttkg.user.controller;

import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.service.ChildService;
import com.example.ttkg.user.service.User_ChildService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChildController {

    private final ChildService childService;
    private final User_ChildService user_childService;

    public ChildController(ChildService childService, User_ChildService user_childService) {
        this.childService = childService;
        this.user_childService = user_childService;
    }


    @GetMapping("/childInfoMain")
    public String childInfoMain(HttpSession session,Model model) {
        UserLoginDTO user = (UserLoginDTO) session.getAttribute("userLoginDTO");
        if(user==null){
            return "login/loginRequired";
        }
        else if(user_childService.ExistChildByUserId(user.getUserIdx())){
            model.addAttribute("existChildFlag",true);
            List<ChildEntity> childEntities=user_childService.findChildEntityListByUserIdx(user.getUserIdx());
            model.addAttribute("childList",childEntities);
            return "myChildInfo/childInfoMain";
        }
        else {
            model.addAttribute("existChildFlag",false);
            return "myChildInfo/childInfoMain";
        }
    }

    @GetMapping("/child_register")
    public String child_register(Model model) {
        ChildDTO childDTO = new ChildDTO();
        model.addAttribute("childDTO", childDTO);
        return "myChildInfo/child_register";
    }
    /**자녀 등록 컨트롤러 그런데 자녀의 이름이 중복일경우 오류 처리 로직 필요*/
    @PostMapping("/child_register_pro")
    public String child_register_pro(ChildDTO childDTO, HttpSession session) {
        UserLoginDTO userLoginDTO=(UserLoginDTO)session.getAttribute("userLoginDTO");
        user_childService.RegisterChild(childDTO, userLoginDTO.getUserIdx());
        return "myChildInfo/child_register_success";
    }
}
