package com.example.demo.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.model.ParentsEntity;

public interface ParentsRepository extends JpaRepository<ParentsEntity, Long> {

}
