package com.example.ttkg.kinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinderController {

    @GetMapping("kinderPage")
    public String KinderPage() {
        return "kinderPage/kinderMain";
    }

    @GetMapping("kinderMeal")
    public String KinderMeal() {
        return "kinderPage/kinderMeal/kinderMeal";
    }

}
