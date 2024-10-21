package com.example.ttkg.kinderFinder.DTO;

import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinderFinder.model.KinderDetailEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KinderResponse {

    private int pageCnt;
    private int currentPage;
    private String sidoList;
    private String sggList;
    private String status;

    @JsonProperty("kinderInfo")
    private List<KinderDetailEntity> kinderInfo;


}
