package com.example.ttkg.kinder.controller;

import com.example.ttkg.kinder.service.KinderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinderController {

    KinderService kinderService;

    public KinderController(KinderService kinderService) {
        this.kinderService = kinderService;
    }

    @GetMapping("kinderPage")
    public String KinderPage() {
        return "kinderPage/kinderMain";
    }

    @GetMapping("kinderMeal")
    public String KinderMeal() {

        System.out.println("유치원 이름 : "+kinderService.findByKinderCode("K001").getKinderName());
        return "kinderPage/kinderMeal";
    }

    @GetMapping("kinderLessonPlan")
    public String KinderLessonPlan() {
        return "kinderPage/kinderLessonPlan";
    }

}
