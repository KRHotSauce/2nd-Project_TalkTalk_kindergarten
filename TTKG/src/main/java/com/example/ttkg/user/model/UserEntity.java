package com.example.ttkg.user.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@SequenceGenerator(
        name = "USER_SEQ_GENERATOR", // 시퀀스 생성기의 이름
        sequenceName = "user_seq",   // 실제 데이터베이스 시퀀스 이름
        initialValue = 1,            // 시작 값
        allocationSize = 1           // 증가 값
)
@Getter
@Setter
@Entity
@Table(name="Users")
public  class UserEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // SEQUENCE 전략 사용
            generator = "USER_SEQ_GENERATOR"    // 생성기 이름
    )
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_id", nullable = false, length = 255)
    private String loginId;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_email", nullable = false, length = 255)
    private String userEmail;

    @Column(name = "user_kind", nullable = false, length = 1)
    private String userKind;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "user_nickname", nullable = false, length = 255)
    private String userNickname;

    @Column(name = "resi_date", nullable = false)
    private LocalDateTime resiDate;

    @Column(name = "profile_img", length = 255)
    private String profileImg;

    @Convert(converter=VerifiedConverter.class)
    @Column(name = "verified", nullable = false)
    private Boolean verified;

}


