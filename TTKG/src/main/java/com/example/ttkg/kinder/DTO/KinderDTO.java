package com.example.ttkg.kinder.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KinderDTO {

    private String kinderCode;  // 기본 키
    private String kinderName;
    private String addr;
    private int establish;
}
