package com.example.ttkg.kinderFinder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "kinderdetail")
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class) //제이슨과 필드명 자동으로 케밥으로
@JsonIgnoreProperties(ignoreUnknown = true) //모르는 변수명은 무시
public class KinderDetailEntity {
    @Id
    @Column(name = "kinderCode", length = 255)
    private String kinderCode;

    @Column(name = "officeedu", length = 255)
    private String officeEdu;

    @Column(name = "subofficeedu", length = 255)
    private String subOfficeEdu;

    @Column(name = "kindername", length = 255)
    private String kinderName;

    @Column(name = "establish")
    private String establish;

    @Column(name = "rppnname", length = 255)
    private String rppnName;

    @Column(name = "idgrname", length = 255)
    private String idgrName;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyyMMdd")
    @Column(name = "edate")
    private LocalDate eDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyyMMdd")
    @Column(name = "odate")
    private LocalDate oDate;

    @Column(name = "addr", length = 255)
    private String addr;

    @Column(name = "tel_no", length = 255)
    private String telNo;

    @Column(name = "fax_no", length = 255)
    private String faxNo;

    @Column(name="hpaddr")
    private String hpAddr;

    @Column(name = "opertime", length = 255)
    private String operTime;

    @Column(name = "cl_cnt3")
    private Integer clCnt3;

    @Column(name = "cl_cnt4")
    private Integer clCnt4;

    @Column(name = "cl_cnt5")
    private Integer clCnt5;

    @Column(name = "mix_cl_cnt")
    private Integer mixClCnt;

    @Column(name = "sh_cl_cnt")
    private Integer shClCnt;

    @Column(name = "prmstf_cnt")
    private Integer prmStfCnt;

    @Column(name = "ag3fp_cnt")
    private Integer ag3FpCnt;

    @Column(name = "ag4fp_cnt")
    private Integer ag4FpCnt;

    @Column(name = "ag5fp_cnt")
    private Integer ag5FpCnt;

    @Column(name = "mixfp_cnt")
    private Integer mixFpCnt;

    @Column(name = "spcnfp_cnt")
    private Integer spcnFpCnt;

    @Column(name = "pp_cnt3")
    private Integer ppCnt3;

    @Column(name = "pp_cnt4")
    private Integer ppCnt4;

    @Column(name = "pp_cnt5")
    private Integer ppCnt5;

    @Column(name = "mixpp_cnt")
    private Integer mixppCnt;

    @Column(name = "chpp_cnt")
    private Integer chppCnt;

    @Column(name = "pbnttmng")
    private Integer pbntTmng;
}

