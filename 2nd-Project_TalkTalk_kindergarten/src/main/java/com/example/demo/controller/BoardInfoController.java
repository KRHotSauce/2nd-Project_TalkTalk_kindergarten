package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.model.BoardInfoEntity;
import com.example.demo.service.BoardInfoService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardInfoController {
	
	@Autowired
	private BoardInfoService boardInfoService;
	
	@GetMapping("/")
	public String getboardFirstEntity(Model model) {
		
		Optional<BoardInfoEntity> boardEntity=boardInfoService.getFirstEntity();
		if(boardEntity.isPresent()) {
			model.addAttribute("boardEntity", boardEntity);
		}
		else {
			model.addAttribute("boardEntity", null);
		}
		return "board";
	}
	
}
