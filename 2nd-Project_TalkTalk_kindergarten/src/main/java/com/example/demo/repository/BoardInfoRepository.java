package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BoardInfoEntity;


public interface BoardInfoRepository extends JpaRepository<BoardInfoEntity,Long> {

	
	
}
