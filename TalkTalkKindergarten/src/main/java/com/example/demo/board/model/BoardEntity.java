package com.example.demo.board.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board_temp")
public class BoardEntity {

    @Id
    @Column(name = "board_info_idx")
    private Long boardInfoIdx;

    @Column(name = "board_name", nullable = false, length = 100)
    private String boardName;

    // Getters and setters
}