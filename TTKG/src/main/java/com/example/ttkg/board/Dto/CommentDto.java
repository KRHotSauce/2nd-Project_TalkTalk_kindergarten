package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.Comment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {

    private Long commentIdx;
    private String body;
    private Long userIdx;
    private String userName;
    private Board boardIdx;
    private String formattedAt;

    public static CommentDto of(Comment comment,String userName, String formattedAt){
        return CommentDto.builder()
                .commentIdx(comment.getCommentIdx())
                .body(comment.getBody())
                .userIdx(comment.getUserIdx())
                .userName(userName)
                .boardIdx(comment.getBoardIdx())
                .formattedAt(formattedAt)
                .build();
    }

}
