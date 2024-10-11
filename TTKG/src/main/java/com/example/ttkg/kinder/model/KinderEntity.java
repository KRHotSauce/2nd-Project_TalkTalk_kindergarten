package com.example.ttkg.kinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="kinder")
@Getter
@Setter
public class KinderEntity {
        @Id
        @Column(name="kindercode")
        private String kinderCode;  // 기본 키
        @Column(name="kindername")
        private String kindername;
        @Column(name="addr")
        private String addr;
        @Column(name="establish")
        private int establish;

    }

