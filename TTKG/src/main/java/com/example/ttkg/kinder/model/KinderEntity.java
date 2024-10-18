package com.example.ttkg.kinder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.EnumNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="kinder")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class) //제이슨과 필드명 자동으로 케밥으로
@JsonIgnoreProperties(ignoreUnknown = true) //모르는 변수명은 무시
public class KinderEntity {
        @Id
        @Column(name="kindercode")
        private String kinderCode;  // 기본 키
        @Column(name="kindername")
        private String kinderName;
        @Column(name="addr")
        private String addr;
        @Column(name="establish")
        private String establish;


    }

