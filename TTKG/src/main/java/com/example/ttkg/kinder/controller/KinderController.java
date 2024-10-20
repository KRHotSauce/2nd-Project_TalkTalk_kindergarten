package com.example.ttkg.kinder.controller;

import com.example.ttkg.kinder.model.NoticeLetterEntity;
import com.example.ttkg.kinder.service.KinderService;
import com.example.ttkg.kinder.service.NoticeLetterService;
import com.example.ttkg.user.DTO.UserLoginDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KinderController {

    KinderService kinderService;
    NoticeLetterService noticeLetterService;

    public KinderController(KinderService kinderService, NoticeLetterService noticeLetterService) {
        this.kinderService = kinderService;
        this.noticeLetterService = noticeLetterService;
    }

    @GetMapping("kinderMain")
    public String RedirectKinderMain(HttpSession session, Model model) {
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
    public String notice(@RequestParam(defaultValue = "1")int page, Model model) {
        Page<NoticeLetterEntity> notices=noticeLetterService.getNoticeLetters(page);
        int totalPage=notices.getTotalPages();
        int startPage=((page-1)/10*10+1);
        int endPage=Math.min(startPage+9,totalPage);

        model.addAttribute("notices", notices.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "kinderPage/kinderIntro/notice";
    }
    
    /**선생님 소개*/
    @GetMapping("teacher_intro")
    public String teacher_intro() {
        return "kinderPage/kinderIntro/teacher-intro";
    }

}
