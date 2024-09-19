package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.model.BoardInfoEntity;
import com.example.demo.service.BoardInfoService;


import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardInfoController {
	
	@Autowired
	private BoardInfoService boardInfoService;
	
	@GetMapping("/")
	public String getboardFirstEntity(Model model) {
		
		BoardInfoEntity boardEntity=boardInfoService.getFirstEntity();
		
		model.addAttribute("boardEntity", boardEntity);
	
		return "board";
	}
	
}
