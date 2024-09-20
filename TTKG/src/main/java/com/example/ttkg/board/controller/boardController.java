package com.example.ttkg.board.controller;

import com.example.ttkg.user.service.ParentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class boardController {

    private ParentsService parentsService;

    @GetMapping("/boardmain")
    public String getallcontents(Model model) {

        return "board/boardmain";
    }


    @GetMapping("/write")
    public String toWritePage(Model model) {

        return "board/write";
    }
    @GetMapping("/modify")
    public String toModifyPage(Model model) {

        return "board/modify";
    }

    @GetMapping("/read")
    public String toReadPage(Model model) {

        return "board/read";
    }


}
