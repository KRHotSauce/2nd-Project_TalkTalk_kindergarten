package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.model.BoardInfoEntity;
import com.example.demo.model.ContentsEntity;
import com.example.demo.service.BoardInfoService;
import com.example.demo.service.ContentsService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardInfoService boardInfoService;
	@Autowired
	private ContentsService contentsService;

	@GetMapping("/")
	public String getboardFirstEntity(Model model) {

		BoardInfoEntity boardEntity = boardInfoService.getFirstEntity();

		model.addAttribute("boardEntity", boardEntity);
		return "board_top";
		

	}

	@GetMapping("/")
	public String getAllContents(Model model) {
		List<ContentsEntity> contentsList = contentsService.getAllContents();
		model.addAttribute("contentsList", contentsList);
		System.out.println("test contents : "+contentsList.get(0).getWRITER());
		return "board";
		
	}

}
