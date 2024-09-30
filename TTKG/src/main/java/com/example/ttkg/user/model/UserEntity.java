package com.example.ttkg.user.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Users")
public  class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_id", nullable = false, length = 255)
    private String loginId;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_email", nullable = false, length = 255)
    private String userEmail;

    @Column(name = "user_kind", nullable = false, length = 1)
    private char userKind;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "user_nickname", nullable = false, length = 255)
    private String userNickname;

    @Column(name = "resi_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date resiDate;

    @Column(name = "profile_img", length = 255)
    private String profileImg;

    @Column(name = "verified", nullable = false)
    private Boolean verified;


}
