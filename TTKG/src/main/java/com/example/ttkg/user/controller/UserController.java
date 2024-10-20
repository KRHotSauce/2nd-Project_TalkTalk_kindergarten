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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private ValidationAutoConfiguration validationAutoConfiguration;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //유저 역할 이동
    @GetMapping("/roleSelect")
    public String roleSelect(/*@RequestParam("email")String email,*/ Model model) {
//        model.addAttribute("email",email);
        return "login/role_selection_register";
    }

    /**회원가입 뷰 이동*/
    @GetMapping("/register")
    public String register(@RequestParam(value = "userKind") String userKind,
                           /*@RequestParam("email")String email,*/ Model model) {

//        model.addAttribute("email",email);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserKind(Integer.parseInt(userKind)); //이전 뷰에서 유저 종류 받아옴
        model.addAttribute("userDTO", userDTO);
        return "login/register";
    }

    /**회원가입 정보 받아오기*/
    @PostMapping("/register_pro")
    public String register_pro(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, Model model) {
        ModelAndView mav = new ModelAndView("login/register");
        if (result.hasErrors()) {
            mav.addObject("userDTO", userDTO); //DTO 유효성검사 안뽑아주기위해서 MAV로 넣어줌
            return "login/register";
        }
        userService.RegisterUserService(userDTO);
        return "login/register_success"; //성공시 알림창 뜨고 메인으로 이동
    }

    /**로그인 뷰 이동 컨트롤러*/
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null)
            model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다");
        return "login/login";
    }

    /**로그인 프로세스 컨트롤러*/
    @PostMapping("login_pro")
    public String login_pro(@RequestParam(value = "loginId") String loginId, @RequestParam(value = "password") String password, HttpSession session, Model model) {
        //로그인 로직 로그인 아이디로 entity 찾은 후 비교 그 이후 loginId로 UserLoginDTO 불러냄
        System.out.println("id: " + loginId);
        System.out.println("pass: " + password);
        if (userService.CheckPasswordByLoginId(loginId, password)) {
            UserLoginDTO userLoginDTO = userService.getUserLoginDTO(loginId);
            session.setAttribute("userLoginDTO", userLoginDTO); //로그인 정보는 세션에 저장
            return "login/login_success";
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login/login";
        }
    }

    /**로그아웃 컨트롤러*/
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userLoginDTO"); //세션에 userLoginDTO 삭제
        return "login/logout_success";
    }

    /**회원정보수정시 비밀번호 확인 컨트롤러*/
    @GetMapping("/editProfileConfirmPassword")
    public String editProfileConfirmPassword(@SessionAttribute("userLoginDTO") UserLoginDTO userLoginDTO, Model model) {
        model.addAttribute("userLoginDTO", userLoginDTO);
        return "login/editProfileConfirmPassword";
    }

    /**비밀번호 확인*/
    @PostMapping("/editProfileConfirmPassword_pro")
    public String editProfileConfirmPassword_pro(@Valid @SessionAttribute("userLoginDTO")UserLoginDTO userLoginDTO,
                                                 @RequestParam("password")String password,
                                                 Model model) {
        if(userService.CheckPasswordByUserIdx(userLoginDTO.getUserIdx(), password)){
            UserDTO userDTO=userService.getUserDTOByUserIdx(userLoginDTO.getUserIdx());
            model.addAttribute("userDTO",userDTO);
            return "login/editProfile";
        }
        model.addAttribute("userLoginDTO", userLoginDTO);
        return "login/editProfileConfirmPassword";
    }

    /**회원정보 수정 프로세스 컨트롤러*/
    @PatchMapping("editProfile_pro")
    public String editProfile_pro(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, Model model
    ,HttpSession session) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            model.addAttribute("userDTO", userDTO);
            return "login/editProfile";
        }
        else {
            UserLoginDTO userLoginDTO=(UserLoginDTO)session.getAttribute("userLoginDTO");
            userLoginDTO.setUserIdx(userDTO.getUserIdx());
            userLoginDTO.setUserNickname(userDTO.getUserNickname());
            session.setAttribute("userLoginDTO", userLoginDTO); //수정된 데이터 세션에 다시 넣어줌
            return "login/updateProfileSuccess";
        }
    }

    @GetMapping("find-id")
    public String findId(Model model) {
        return "login/find-id";
    }

    @PostMapping("find-id_pro")
    public String findId_pro(@Valid @RequestParam String userName,
                             @RequestParam String userEmail, Model model) {

        try {
            String LoginId= userService.findUserLoginIdByUserNameAndUserEmail(userName, userEmail);
            model.addAttribute("loginId", LoginId);
            return "login/find-id_success";
        }
        catch(IllegalArgumentException e){
            model.addAttribute("errorMessage", "입력한 정보와 일치하는 아이디가 없습니다.");
            return "login/find-id";
        }

    }

    @GetMapping("find-pass")
    public String findPass(Model model) {
        return "login/find-pass";
    }

    @PostMapping("find-password_pro")
    public String findPasswordPro(@RequestParam String loginId, Model model) {
        try {
            userService.logicTemporaryPassword(loginId);
            return "login/find-pass_success";
        }
        catch(IllegalArgumentException e){
            model.addAttribute("errorMessage",e.getMessage());
            return "login/find-pass";
        }
    }

}
