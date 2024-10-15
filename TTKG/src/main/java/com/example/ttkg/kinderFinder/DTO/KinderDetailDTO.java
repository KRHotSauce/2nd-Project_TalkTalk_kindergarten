package com.example.ttkg.kinderFinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class KinderDetailDTO {

    private String kinderCode;

    private String officeEdu;

    private String subOfficeEdu;

    private String kinderName;

    private Integer establish;

    private String rppnName;

    private String idgrName;

    private LocalDate eDate;

    private LocalDate oDate;

    private String addr;

    private String telNo;

    private String faxNo;

    private String operTime;

    private Integer clCnt3;

    private Integer clCnt4;

    private Integer clCnt5;

    private Integer mixClCnt;

    private Integer shClCnt;

    private Integer prmStfCnt;

    private Integer ag3FpCnt;

    private Integer ag4FpCnt;

    private Integer ag5FpCnt;

    private Integer mixFpCnt;

    private Integer spcnFpCnt;

    private Integer ppCnt3;

    private Integer ppCnt4;

    private Integer ppCnt5;

    private Integer mixppCnt;

    private Integer chppCnt;

    private Integer pbntTmng;
}

