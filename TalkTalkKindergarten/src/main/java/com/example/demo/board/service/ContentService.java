package com.example.demo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.model.ContentsEntity;
import com.example.demo.board.repository.ContentRepository;

import jakarta.transaction.Transactional;

@Service
public class ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	@Transactional
	public List<ContentsEntity> getallContents(){
		return contentRepository.findAll();
	}
	
}
