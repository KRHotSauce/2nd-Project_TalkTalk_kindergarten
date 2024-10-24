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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "login/register";
        }

        if(userDTO.getKinderCode()==null&&userDTO.getUserKind()==1){
            userService.RegisterUserService(userDTO,userDTO.getUserKind());
            return "login/register_success"; //성공시 알림창 뜨고 메인으로 이동
        }

        if(userDTO.getKinderCode()!=null&&userDTO.getUserKind()==0){
            userService.RegisterUserService(userDTO,0);
            return "login/register_success";
        }

        return "login/register";

    }

    /**로그인 뷰 이동 컨트롤러*/
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        return "login/login";
    }

    /**로그인 프로세스 컨트롤러*/
    @PostMapping("login_pro")
    public String login_pro(@RequestParam(value = "loginId") String loginId, @RequestParam(value = "password") String password,
                            HttpSession session, Model model,RedirectAttributes redirectAttributes) {
        //로그인 로직 로그인 아이디로 entity 찾은 후 비교 그 이후 loginId로 UserLoginDTO 불러냄
        System.out.println("id: " + loginId);
        System.out.println("pass: " + password);
        if (userService.CheckPasswordByLoginId(loginId, password)) {
            UserLoginDTO userLoginDTO = userService.getUserLoginDTO(loginId);
            session.setAttribute("userLoginDTO", userLoginDTO); //로그인 정보는 세션에 저장
            return "login/login_success";
        }
        redirectAttributes.addFlashAttribute("loginFailed",userService.CheckPasswordByLoginId(loginId,password));
            return "redirect:/login";

    }

    /**로그아웃 컨트롤러*/
    @GetMapping("/logoutSuccess")
    public String logoutSuccess() {
        return "login/logout_success";  // 템플릿 폴더 안의 logout_success.html 반환
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
    @PostMapping("editProfile_pro")
    public String editProfile_pro(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, Model model
    ,HttpSession session) {
        ModelAndView mav = new ModelAndView("login/editProfile");
        if (result.hasErrors()) {
            mav.addObject("userDTO", userDTO); //DTO 유효성검사 안뽑아주기위해서 MAV로 넣어줌
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            System.out.println("작동 1번");
            return "login/editProfile";
        }

        if(userDTO.getUserKind()==1){
            userService.updateUser(userDTO);
            return "login/updateProfileSuccess"; //성공시 알림창 뜨고 메인으로 이동
        }

        if(userDTO.getKinderCode()!=null&&userDTO.getUserKind()==0){
            userService.updateUser(userDTO);
            return "login/updateProfileSuccess";
        }
        System.out.println("작동 2번");
        return "login/editProfile";
    }

    @GetMapping("find-id")
    public String findId(Model model) {
        return "login/find-id";
    }

    @PostMapping("find-id_pro")
    public String findId_pro(@RequestParam("userName") String userName,
                             @RequestParam("userEmail") String userEmail, Model model,RedirectAttributes redirectAttributes) {

        try {
            String LoginId= userService.findUserLoginIdByUserNameAndUserEmail(userName, userEmail);
            model.addAttribute("loginId", LoginId);
            redirectAttributes.addFlashAttribute("successMessage","회원님의 아이디는 "+LoginId+"입니다.");
            return "redirect:/find-id";
        }
        catch(IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("errorMessage","일치하는 이름 혹은 이메일이 없습니다");
            return "redirect:/find-id";
        }

    }

    @GetMapping("find-pass")
    public String findPass(Model model) {
        return "login/find-pass";
    }

    @PostMapping("find-password_pro")
    public String findPasswordPro(@RequestParam String loginId, Model model,RedirectAttributes redirectAttributes) {
            if(userService.checkExistByLoginId(loginId)){
                userService.logicTemporaryPassword(loginId);
                return "login/find-pass_success";
            }
            redirectAttributes.addFlashAttribute("errorMessage","아이디가 존재하지 않습니다.");
            return "redirect:/find-pass";

    }

}
