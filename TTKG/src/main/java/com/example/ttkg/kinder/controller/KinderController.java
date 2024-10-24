package com.example.ttkg.kinder.controller;

import com.example.ttkg.kinder.model.NoticeLetterEntity;
import com.example.ttkg.kinder.service.KinderService;
import com.example.ttkg.kinder.service.NoticeLetterService;
import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.service.User_ChildService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class KinderController {

    private final KinderService kinderService;
    private final NoticeLetterService noticeLetterService;
    private final User_ChildService user_childService;

    @GetMapping("kinderMain")
    public String RedirectKinderMain(HttpSession session, Model model) {
       return "kinderPage/kinderMain";

    }

    @GetMapping("kinderMeal")
    public String KinderMeal(Model model, HttpSession session) {
        UserLoginDTO userLoginDTO = (UserLoginDTO) session.getAttribute("userLoginDTO");
        List<ChildDTO> childList = user_childService.findChildEntityListByUserIdx(userLoginDTO.getUserIdx());
        Iterator<ChildDTO> childIter = childList.iterator();
        String allergy = "";
        /*각 아이마다 생선이나 콩이 있나 확인 만일 나중에 식단이 더 추가되면
        HashSet에 알레르기 정보를 저장 후 model로 넘기면 됨. 지금도 그 방법이 차라리 좋을지도...*/
        while(childIter.hasNext()){
            ChildDTO child = childIter.next();
            String[] allergies = child.getChildAllergy().split(", ");
            List<String> allergyList = new ArrayList<>(Arrays.asList(allergies));
            if(allergyList.contains("생선")){
                allergy += " 생선";
            }
            if(allergyList.contains("콩")){
                allergy += " 콩";
            }
        }
        model.addAttribute("allergy", allergy);
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
