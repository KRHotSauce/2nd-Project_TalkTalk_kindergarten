package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BoardInfoEntity;
import com.example.demo.repository.BoardInfoRepository;

@Service
public class BoardInfoService {

	@Autowired
	private BoardInfoRepository boardInfoRepository;
	
	public Optional<BoardInfoEntity> getFirstEntity(){
		return boardInfoRepository.findById(1L);
	}
}
