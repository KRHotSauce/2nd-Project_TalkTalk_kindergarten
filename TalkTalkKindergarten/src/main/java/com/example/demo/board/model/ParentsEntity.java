package com.example.demo.board.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name="prants_temp")
@Entity
public class ParentsEntity {
	  @Id
	    @Column(name = "user_id")
	    private Long userId;

	    @Column(name = "login_id", nullable = false, length = 100)
	    private String loginId;

	    @Column(name = "password", nullable = false, length = 100)
	    private String password;

	    @Column(name = "email", nullable = false, length = 200)
	    private String email;

	    @Column(name = "name", nullable = false, length = 100)
	    private String name;

	    @Column(name = "user_kind", length = 1)
	    private Character userKind;

	    // Getters and setters
}
