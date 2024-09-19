package com.example.demo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.board.model.ContentsEntity;
import com.example.demo.board.service.ContentService;


@Controller
public class ContentController {

	@Autowired
	ContentService contentService;
	
	 @GetMapping("/")
	    public String getlistContents(Model model) {
	        List<ContentsEntity> contentsList = contentService.getallContents();
	        model.addAttribute("contentsList",contentsList );
	        return "board/board_main";
	    }
	
}
