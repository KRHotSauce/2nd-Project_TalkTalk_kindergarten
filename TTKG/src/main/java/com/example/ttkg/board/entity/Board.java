package com.example.ttkg.board.entity;

import com.example.ttkg.board.Dto.BoardCreateRequest;
import com.example.ttkg.board.Dto.BoardDto;
import com.example.ttkg.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tt_boards")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_idx_generator")
    @SequenceGenerator(name="board_idx_generator", sequenceName = "board_idx_seq", allocationSize = 1)
    @Column(name="board_idx")
    private Long boardIdx;

    @Enumerated(EnumType.STRING)
    private BoardCategory category;

    /*private UserEntity user;*/

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "author")
    private String author;

    @Column(name = "image")
    private String image;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "user_idx")
    private Long userIdx;

    /*public void update(BoardDto dto){
        this.title = dto.getTitle();
        this.body = dto.getBody();
    }*/

    public void update(BoardCreateRequest boardCreateRequest) {
        this.title = boardCreateRequest.getTitle();
        this.body = boardCreateRequest.getBody();
    }

}
