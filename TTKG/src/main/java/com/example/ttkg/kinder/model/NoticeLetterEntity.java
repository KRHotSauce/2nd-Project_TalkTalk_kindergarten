package com.example.ttkg.kinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="notice_letter")
@SequenceGenerator(
        name = "NOTICE_SEQ_GENERATOR",
        sequenceName = "NOTICE_LETTER_SEQ",
        allocationSize = 1
)
public class NoticeLetterEntity {
    @Id
    @Column(name="letter_idx")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "NOTICE_SEQ_GENERATOR"
    )
    long letterIdx;
    @Column(name="kinderCode")
    String kinderCode;
    @Column(name="notice_date")
    LocalDateTime noticeDate;
    @Column(name="body")
    String body;
}
