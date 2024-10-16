package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import com.example.ttkg.user.model.UserEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardCreateRequest {
    
    // edit을 위한 속성
    private Long boardIdx;
    private String title;
    private String body;
    private BoardCategory category;

    public Board toEntity(UserEntity user) {
        return Board.builder()
                .userIdx(user.getUserIdx())
                .category(category)
                .title(title)
                .body(body)
                .author(user.getUserName())
                .viewCount(0L)
                .build();
    }
}