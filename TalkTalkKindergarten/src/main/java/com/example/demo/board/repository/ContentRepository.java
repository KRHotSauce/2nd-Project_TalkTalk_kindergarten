package com.example.demo.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.model.ContentsEntity;

public interface ContentRepository extends JpaRepository<ContentsEntity, Long> {

}
