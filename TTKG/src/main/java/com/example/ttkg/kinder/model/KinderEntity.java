package com.example.ttkg.kinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="kinder")
@Getter
@Setter
public class KinderEntity {
        @Id
        @Column(name="kindercode")
        private String kinderCode;  // 기본 키
        @Column(name="kindername")
        private String kinderName;
        @Column(name="addr")
        private String addr;
        @Column(name="establish")
        private int establish;


    }

