package com.example.ttkg.user.controller;

import com.example.ttkg.user.DTO.ParentsDTO;
import com.example.ttkg.user.model.ParentsEntity;
import com.example.ttkg.user.service.ParentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    private final ParentsService parentsService;

    public UserController(ParentsService parentsService) {
        this.parentsService = parentsService;
    }

    @GetMapping("/login")
    public String toLoginPage(Model model) {

        return "Login/Login";
    }

    @GetMapping("/register")
    public String toRegisterPage(Model model) {

        return "Login/Register";
    }

    @PostMapping("/register_pro")
    public String registerPro(@ModelAttribute ParentsDTO parentsDTO, RedirectAttributes redirectAttributes) {
        try{
            parentsService.registerNewParent(parentsDTO);
            redirectAttributes.addFlashAttribute("message","회원가입을 축하드립니다!");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error",e.getMessage());
            return "redirect:/register";
        }
    }


}
