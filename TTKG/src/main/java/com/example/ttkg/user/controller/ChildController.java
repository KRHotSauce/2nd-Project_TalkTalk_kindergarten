package com.example.ttkg.user.controller;

import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.model.NoticeLetterEntity;
import com.example.ttkg.kinder.service.KinderService;
import com.example.ttkg.user.DTO.ChildCreateRequest;
import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.service.ChildService;
import com.example.ttkg.user.service.UserService;
import com.example.ttkg.user.service.User_ChildService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;
    private final UserService userService;
    private final User_ChildService user_childService;
    private final KinderService kinderService;

    @GetMapping("/children")
    public String children(HttpSession session,Model model) {
        UserLoginDTO user = (UserLoginDTO) session.getAttribute("userLoginDTO");
        if(user==null){
            return "login/loginRequired";
        }
        //선생님 아이디로 들어갈 시
        else if(!user.isUserKind()
                &&user.getKinderCode()!=null
                &&user_childService.existByKinderCode(user.getKinderCode())){
            List<ChildEntity> applyChildList=user_childService.getChildEntityByKinder(user.getKinderCode(),2);
            List<ChildEntity> childEntityList =user_childService.getChildEntityByKinder(user.getKinderCode(),1);
            model.addAttribute("applyChildList",applyChildList);
            model.addAttribute("childEntityList",childEntityList);
            model.addAttribute("existChildFlag",true);
            return "myChildInfo/children";

        }
        else if(user_childService.ExistChildByUserId(user.getUserIdx())){
            model.addAttribute("existChildFlag",true);
            List<ChildEntity> childEntities=user_childService.findChildEntityListByUserIdx(user.getUserIdx());
            model.addAttribute("childList",childEntities);
            return "myChildInfo/children";
        }

        else {
            model.addAttribute("existChildFlag",false);
            return "myChildInfo/children";
        }
    }

    @GetMapping("/child_register")
    public String child_register(Model model, HttpSession session) {
        UserLoginDTO user = (UserLoginDTO) session.getAttribute("userLoginDTO");
        ChildCreateRequest req = new ChildCreateRequest();
        model.addAttribute("req", req);
        return "myChildInfo/child_register";
    }

    /**자녀 등록 컨트롤러 그런데 자녀의 이름이 중복일경우 오류 처리 로직 필요*/
    @PostMapping("/child_register_pro")
    public String child_register_pro(ChildCreateRequest req, HttpSession session) {
        UserLoginDTO userLoginDTO=(UserLoginDTO)session.getAttribute("userLoginDTO");
        System.out.println(req.toString());
        user_childService.RegisterChild(req, userLoginDTO.getUserIdx());
        return "myChildInfo/child_register_success";
    }

    @GetMapping("/child_info")
    public String getChildInfo(@RequestParam(value = "childIdx")Long childIdx,
                               Model model, HttpSession session) {
        UserLoginDTO userLoginDTO = (UserLoginDTO)session.getAttribute("userLoginDTO");
        model.addAttribute("child", childService.getChildEntity(childIdx));
        model.addAttribute("user", userService.getUserViewDTOByUserIdx(userLoginDTO.getUserIdx()));
        model.addAttribute("user_child",user_childService.getUser_ChildEntityByChildIdx(childIdx));
        model.addAttribute("childIdx",childService.getChildRealEntity(childIdx).getChildIdx());

        return "myChildInfo/child_info";
    }

    @PostMapping("/approveKinderApply")
    public String approveKinderApply(@RequestParam long childIdx,@RequestParam String kinderCode) {
        user_childService.approveApply(childIdx, kinderCode);
        return "redirect:/children";
    }

    @PostMapping("/deniedKinderApply")
    public String deniedKinderApply(@RequestParam long childIdx) {
        return "redirect:/children";
    }
}
