package com.example.ttkg.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "tt_comments")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_idx_generator")
    @SequenceGenerator(name="comment_idx_generator", sequenceName = "comment_idx_seq", allocationSize = 1)
    @Column(name = "comment_idx")
    private Long commentIdx;

    @Column(name = "body")
    private String body;

    @Column(name = "user_idx")
    private Long userIdx;

    @ManyToOne
    @JoinColumn(name = "board_idx", referencedColumnName = "board_idx")
    private Board boardIdx;

}
