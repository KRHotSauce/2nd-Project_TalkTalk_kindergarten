package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.Comment;
import com.example.ttkg.user.model.UserEntity;
import lombok.Data;

@Data
public class CommentCreateRequest {

    private String body;
    private Long userIdx;
    private Long boardIdx;

    public Comment toEntity(Board board, UserEntity user) {
        return Comment.builder()
                .userIdx(user.getUserIdx())
                .boardIdx(board)
                .body(body)
                .build();
    }

}
