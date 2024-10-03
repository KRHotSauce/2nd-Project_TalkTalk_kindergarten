package com.example.ttkg.user.controller;

import com.example.ttkg.user.DTO.UserDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private ValidationAutoConfiguration validationAutoConfiguration;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/roleSelect")
    public String roleSelect(Model model) {
        return "login/role_selection_register";
    }

    @GetMapping("/register")
    public String register(@RequestParam(value = "userKind") String userKind, Model model) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserKind(userKind);
        model.addAttribute("userDTO", userDTO);
        System.out.println("UserKind : " + userKind);
        return "login/register";
    }

    @PostMapping("/register_pro")
    public String register_pro(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("레지스터 프로");
            System.out.println("에러 : " + result.getAllErrors());
            System.out.println("userKind : " + userDTO.getUserKind());
            model.addAttribute("userDTO", userDTO);
            return "login/register";
        }


        userService.RegisterUserService(userDTO);
        return "login/register_success";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null)
            model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다");
        return "login/login";
    }


    @PostMapping("login_pro")
    public String login_pro(@RequestParam String loginId, @RequestParam String password, HttpSession session, Model model) {
        //로그인 로직 로그인 아이디로 entity 찾은 후 비교 그 이후 loginId로 UserLoginDTO 불러냄
        if (userService.CheckPasswordByLoginId(loginId, password)) {
            UserLoginDTO userLoginDTO = userService.getUserLoginDTO(loginId);

            session.setAttribute("userLoginDTO", userLoginDTO);

            UserLoginDTO test = (UserLoginDTO) session.getAttribute("userLoginDTO");
            if (test != null) {
                System.out.println("닉네임: " + test.getUserNickname());
            } else {
                System.out.println("세션에 userLoginDTO가 없습니다.");
            }
            return "login/login_success";
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userLoginDTO");
        return "login/logout_success";
    }

    @GetMapping("/editProfileConfirmPassword")
    public String editProfileConfirmPassword(@SessionAttribute("userLoginDTO") UserLoginDTO userLoginDTO, Model model) {
        model.addAttribute("userLoginDTO", userLoginDTO);
        return "login/editProfileConfirmPassword";
    }


    @PostMapping("/editProfileConfirmPassword_pro")
    public String editProfileConfirmPassword_pro(@Valid @SessionAttribute("userLoginDTO")UserLoginDTO userLoginDTO,
                                                 @RequestParam("password")String password,
                                                 Model model) {
        if(userService.CheckPasswordByUserId(userLoginDTO.getUserId(), password)){
            UserDTO userDTO=userService.getUserByUserId(userLoginDTO.getUserId());
            model.addAttribute("userDTO",userDTO);
            return "login/editProfile";
        }
        model.addAttribute("userLoginDTO", userLoginDTO);
        return "login/editProfileConfirmPassword";
    }


}
