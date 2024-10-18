package com.example.ttkg.kinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KinderAlbumController {

    @GetMapping("kinderAlbum")
    public String community(@RequestParam(defaultValue = "1")int page, Model model) {
//        Page<NoticeLetterEntity> notices=noticeLetterService.getNoticeLetters(page);
//        int totalPage=notices.getTotalPages();
//        int startPage=((page-1)/10*10+1);
//        int endPage=Math.min(startPage+9,totalPage);
//
//        model.addAttribute("notices", notices.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPage);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);
        return "kinderPage/kinderAlbum";
    }
}
