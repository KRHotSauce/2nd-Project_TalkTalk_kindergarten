package com.example.ttkg.user.controller;

import com.example.ttkg.user.DTO.UserDTO;
import com.example.ttkg.user.repository.UserRepository;
import com.example.ttkg.user.service.CustomOAuth2UserService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoogleLoginController {

    private final UserRepository userRepository;
    private final CustomOAuth2UserService customOAuth2UserService;

    public GoogleLoginController(UserRepository userRepository, CustomOAuth2UserService customOAuth2UserService) {
        this.userRepository = userRepository;
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @GetMapping("/login/google-login_pro")
    public String googleLoginSuccess(OAuth2AuthenticationToken token, Model model) {
        String email=token.getPrincipal().getAttribute("email");
        if(userRepository.existsByUserEmail(email)) {
            return "login/google-login_success";
        }
        else {
            model.addAttribute("email", email);
            return "login/role_selection_register";
        }

    }

    @PostMapping("/google-register_pro")
    public String register_pro(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                               @RequestParam("userEmail")String email, BindingResult result, Model model) {
        ModelAndView mav = new ModelAndView("login/register");
        if (result.hasErrors()) {
            mav.addObject("userDTO", userDTO); //DTO 유효성검사 안뽑아주기위해서 MAV로 넣어줌
            model.addAttribute("email", email);
            return "login/register";
        }
        return "login/register_success"; //성공시 알림창 뜨고 메인으로 이동
    }
}
