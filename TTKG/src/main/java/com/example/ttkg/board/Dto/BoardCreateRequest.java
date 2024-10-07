package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardCreateRequest {

    private String title;
    private String body;
    private String author;
    private MultipartFile uploadImage;

    public Board toEntity(BoardCategory category/*, User user*/) {
        return Board.builder()
                .userIdx(1L)
                .category(category)
                .title(title)
                .body(body)
                .author(author)
                .viewCount(0L)
                .build();
    }
}