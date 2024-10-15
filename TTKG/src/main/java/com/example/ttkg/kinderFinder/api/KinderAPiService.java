package com.example.ttkg.kinderFinder.api;

import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.repository.KinderRepository;
import com.example.ttkg.kinderFinder.DTO.KinderResponse;
import com.example.ttkg.kinderFinder.model.KinderDetailEntity;
import com.example.ttkg.kinderFinder.repository.KinderDetailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class KinderAPiService {

    private final String[] sggCode={"11110","11170,","11140"};
    private final KinderRepository kinderRepository;
    private final ObjectMapper objectMapper;

    KinderDetailRepository KinderDetailRepository;
    KinderRepository KinderRepository;

    public KinderAPiService(KinderDetailRepository KinderDetailRepository, KinderRepository KinderRepository, KinderRepository kinderRepository) {
        this.KinderDetailRepository = KinderDetailRepository;
        this.KinderRepository = KinderRepository;
        this.kinderRepository = kinderRepository;
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }



    public String geKinderDataBySggCode(String sggCode){
        String API_URL="https://e-childschoolinfo.moe.go.kr/api/notice/basicInfo.do?key=c377c7e042b1421091e98f2107692809&sidoCode=11&sggCode="+sggCode;
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(API_URL, String.class);
    }

    public void processGetKinderDataMultiple() throws Exception{
        for(String sggCode:this.sggCode){
            String jsonData=geKinderDataBySggCode(sggCode);
            processGetKinderData(jsonData);
        }
    }

    public KinderResponse parseKinderResponse(String jsonData) throws Exception{
        return objectMapper.readValue(jsonData, KinderResponse.class);
    }


    private void processGetKinderData(String jsonData) throws Exception{
        KinderResponse kinderResponse=parseKinderResponse(jsonData);
        List<KinderDetailEntity> kinderDetailEntityList= kinderResponse.getKinderInfo();
        List<KinderEntity> kinderEntityList=new ArrayList<>();
        for(KinderDetailEntity kinderDetailEntity:kinderDetailEntityList){
            KinderEntity kinderEntity=new KinderEntity();
            kinderEntity.setKinderCode(kinderDetailEntity.getKinderCode());
            kinderEntity.setKinderName(kinderDetailEntity.getKinderName());
            kinderEntity.setAddr(kinderDetailEntity.getAddr());
            kinderEntity.setEstablish(kinderDetailEntity.getEstablish());
            kinderEntityList.add(kinderEntity);
        }
        saveAllKinderData(kinderEntityList,kinderDetailEntityList);
    }

    private void saveAllKinderData(List<KinderEntity> kinderEntityList,List<KinderDetailEntity> kinderDetailEntityList) throws Exception{
        kinderRepository.saveAll(kinderEntityList);
        KinderDetailRepository.saveAll(kinderDetailEntityList);
    }

}
