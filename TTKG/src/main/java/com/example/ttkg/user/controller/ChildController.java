package com.example.ttkg.user.controller;

import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.service.ChildService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }


    @GetMapping("/childInfoMain")
    public String childInfoMain(HttpSession session) {
        if(session.getAttribute("userLoginDTO")==null){
            return "login/loginRequired";
        }
        else
            return "myChildInfo/childInfoMain";
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
        childService.RegisterChild(childDTO, userLoginDTO.getUserIdx());
        return "myChildInfo/child_register_success";
    }
}
