package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardDto {

    private Long boardIdx;
    private BoardCategory category;
    private String title;
    private String author;
    private String formattedCreatedAt;
    private LocalDateTime lastModifiedAt;
    private String image;
    private Long viewCount;
    private String body;
    private Long userIdx;

    public static BoardDto of(Board board, String formattedCreatedAt){
        return BoardDto.builder()
                .boardIdx(board.getBoardIdx())
                .category(board.getCategory())
                .title(board.getTitle())
                .author(board.getAuthor())
                .formattedCreatedAt(formattedCreatedAt)
                .lastModifiedAt(board.getLastModifiedAt())
                .image(board.getImage())
                .viewCount(board.getViewCount())
                .body(board.getBody())
                .userIdx(board.getUserIdx())
                .build();
    }

}
