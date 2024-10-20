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

    @GetMapping("kinderMain")
    public String KinderPage() {
        return "kinderPage/kinderMain";
    }

    @GetMapping("kinderMeal")
    public String KinderMeal() {
        return "kinderPage/kinderMeal";
    }

    @GetMapping("kinderLessonPlan")
    public String KinderLessonPlan() {
        return "kinderPage/kinderLessonPlan";
    }
    /**원장 인사말*/
    @GetMapping("greeting")
    public String greeting() {
        return "kinderPage/kinderIntro/greeting";
    }
    /**유치원 전경*/
    @GetMapping("overview")
    public String overview() {
        return "kinderPage/kinderIntro/kinder-overview";
    }
    
    /**공지사항*/
    @GetMapping("notice")
    public String notice() {
        return "kinderPage/kinderIntro/notice";
    }
    
    /**선생님 소개*/
    @GetMapping("teacher_intro")
    public String teacher_intro() {
        return "kinderPage/kinderIntro/teacher-intro";
    }

}
