package com.example.ttkg.board.Dto;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class BoardDto {

    private Long boardIdx;
    private BoardCategory category;
    private String title;
    private String author;
    private String formattedAt;
    private String image;
    private Long viewCount;
    private String body;
    private Long userIdx;

    public static BoardDto of(Board board){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedAt = board.getCreatedAt().format(formatter);

        return BoardDto.builder()
                .boardIdx(board.getBoardIdx())
                .category(board.getCategory())
                .title(board.getTitle())
                .author(board.getAuthor())
                .formattedAt(formattedAt)
                .image(board.getImage())
                .viewCount(board.getViewCount())
                .body(board.getBody())
                .userIdx(board.getUserIdx())
                .build();
    }

}
