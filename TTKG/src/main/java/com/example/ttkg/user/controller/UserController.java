package com.example.ttkg.user.controller;

import com.example.ttkg.user.DTO.UserRegiDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String toRegisterPage(Model model) {
    model.addAttribute("parentsDTO",new UserRegiDTO());
        return "Login/Register";
    }

    @PostMapping("/register_pro")
    public String registerPro(@Valid @ModelAttribute("parentsDTO") UserRegiDTO userRegiDTO
    , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        //비밀번호 일치 유효성검사
        if (!userRegiDTO.getPassword().equals(userRegiDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "비밀번호가 일치하지 않습니다.");
        }

        //비밀번호 외의 유효성 검사
        if(bindingResult.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.parentsDTO", bindingResult);
            model.addAttribute("parentsDTO", userRegiDTO);
            return "Login/Register";

        }
        // 사용자 등록
        userService.registerNewParent(userRegiDTO);

        // 회원가입 성공 시 메시지 추가
        redirectAttributes.addFlashAttribute("successMessage", "회원가입 되었습니다");

        return "redirect:register_success"; // 성공 페이지로 리다이렉트



    }
    @GetMapping("/register_success")
    public String registerSuccess(Model model) {
        // 필요에 따라 추가적인 데이터 모델에 담기
        return "Login/register_success"; // 성공 메시지를 보여줄 뷰 이름
    }

    @GetMapping("/login")
    public String toLoginPage(Model model) {
        model.addAttribute("parentsLoginDTO",new UserLoginDTO());
        return "Login/Login";
    }

    @PostMapping("login_pro")
    public String loginPro(@Valid @ModelAttribute("parentsLoginDTO") UserLoginDTO userLoginDTO,
                           BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.parentsLoginDTO", bindingResult);
            model.addAttribute("parentsLoginDTO", userLoginDTO);
            return "Login/Login"; // 오류가 있을 경우 로그인 페이지로 돌아감
        }
        else if(userService.checkLogin(userLoginDTO)){
            session.setAttribute("parentsLoginDTO", userLoginDTO);
            return "redirect:login_success";
        }
        else{
            model.addAttribute("loginFailed","아이디 또는 비밀번호가 일치하지 않습니다");
            model.addAttribute("parentsLoginDTO", userLoginDTO);
            return "Login/Login";
        }
    }

    @GetMapping("/login_success")
    public String loginSuccess(Model model) {

        return "Login/login_success"; // 성공 메시지를 보여줄 뷰 이름
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        try {
            if(session.getAttribute("parentsLoginDTO") != null){
                session.invalidate();
                return "Login/logout_success";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "/ErrorPage";
    }
    @GetMapping("editProfileConfirmPassword")
    public String editProfileConfirmPassword(Model model,HttpSession session) {
        model.addAttribute("parentsLoginDTO",(UserLoginDTO)session.getAttribute("parentsLoginDTO"));
        return "Login/editProfileConfirmPassword";
    }

    @PostMapping("editProfileConfirmPassword_pro")
    public String editProfileConfirmPassword(Model model,HttpSession session,@RequestParam String confirmPassword) {
        UserLoginDTO confirmPassDTO = (UserLoginDTO) session.getAttribute("parentsLoginDTO");
        if(confirmPassDTO == null){
            return "Login/ErrorPage";
        }
        else if(userService.chekcPassword(confirmPassDTO,confirmPassword)
        && userService.getParentsEntitybyLoginID(confirmPassDTO.getLoginId())!=null){

            model.addAttribute("parentsDTO", userService.getParentsEntitybyLoginID(confirmPassDTO.getLoginId()));
            return "Login/editProfile";
        }
        else{
            model.addAttribute("loginFailed","비밀번호가 일치하지 않습니다");
            model.addAttribute("parentsLoginDTO",confirmPassDTO);
            return "/Login/editProfileConfirmPassword";
        }


    }

    @GetMapping("editProfile")
    public String editProfile(Model model,HttpSession session) {
        return "/Login/editProfile";
    }

    @PostMapping("updateProfile")
    public String updateProfile(@Valid @ModelAttribute("parentsDTO") UserRegiDTO parentsUpdateDTO
            , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (!parentsUpdateDTO.getPassword().equals(parentsUpdateDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "비밀번호가 일치하지 않습니다.");
            //비밀번호 일치 유효성검사
        }
        if(bindingResult.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.parentsDTO", bindingResult);
            model.addAttribute("parentsUpdateDTO", parentsUpdateDTO);
            return "Login/editProfile";
            //비밀번호 외의 유효성 검사
        }
        userService.UpdateParentsProfile(parentsUpdateDTO,parentsUpdateDTO.getLoginId());

        return "/Login/updateProfileSuccess";

    }


    @PostMapping("deleteAccount")
    public String deleteAccount(HttpSession session) {
        UserLoginDTO userLoginDTO =(UserLoginDTO)session.getAttribute("parentsLoginDTO");
        userService.DeleteAccountMethod(userLoginDTO.getLoginId());
        session.removeAttribute("parentsLoginDTO");
        return "Login/delete_account_success";
    }


//    @PostMapping("searchParents_pro")
//    public String searchParents_pro(Model model,HttpSession session) {
//
//    }




}
