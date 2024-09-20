package com.example.ttkg.user.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Parents")
public  class ParentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_id", nullable = false, length = 100)
    private String loginId;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

}
