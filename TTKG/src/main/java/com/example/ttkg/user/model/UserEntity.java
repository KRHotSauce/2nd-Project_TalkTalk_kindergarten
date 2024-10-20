package com.example.ttkg.user.model;


import com.example.ttkg.kinder.model.KinderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "user_idx", updatable = false, nullable = false)
    private Long userIdx;

    @Column(name = "login_id", nullable = true, length = 255)
    private String loginId;

    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Column(name = "user_email", nullable = false, length = 255)
    private String userEmail;

    @Column(name = "user_kind", nullable = true, length = 1)
    private boolean userKind;

    @Column(name = "user_name", nullable = true, length = 255)
    private String userName;

    @Column(name = "user_nickname", nullable = true, length = 255)
    private String userNickname;

    @Column(name = "resi_date", nullable = true)
    private LocalDateTime resiDate;

    @Column(name="kindercode",nullable = true)
    String kinderCode;

    @OneToMany(mappedBy = "users",cascade = CascadeType.REMOVE)
    private Set<User_ChildEntity> user_childEntities=new HashSet<>();

//    @Enumerated(EnumType.STRING)
//    @Column(name="authprovider", nullable = false)
//    private AuthProvider authprovider;
//
//    public enum AuthProvider{
//        LOCAL,
//        GOOGLE
//    }

}




