package com.example.demo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.model.BoardEntity;
import com.example.demo.board.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public List<BoardEntity> getAllBoard(){
		return boardRepository.findAll();
	}
	
	public BoardEntity getBoardbyId(Long id){
		return boardRepository.findById(id).orElse(null);
	}
}
