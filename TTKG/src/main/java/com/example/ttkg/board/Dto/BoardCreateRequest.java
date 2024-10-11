package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import com.example.ttkg.user.model.UserEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardCreateRequest {

    private String title;
    private String body;
    private MultipartFile uploadImage;

    public Board toEntity(BoardCategory category, UserEntity user) {
        return Board.builder()
                .userId(user.getUserId())
                .category(category)
                .title(title)
                .body(body)
                .author(user.getUserName())
                .viewCount(0L)
                .build();
    }
}