package com.example.ttkg.kinderFinder.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/kinder-finder")
public class FinderRestController {

    @GetMapping("/init")
    public ResponseEntity<String> getKinderInfo(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();


//        "11380", "11545", "11590", "11680", "11110", "11170", "11215", "11470", "11620", "11410", "11440", "11200", "11305", "11650", "11710", "11740", "11290", "11320", "11350", "11500", "11530", "11230"
        String[] sggCodes={"11110", "11170,", "11140", "11560", "11260"};
        String key = "https://e-childschoolinfo.moe.go.kr/api/notice/basicInfo.do?key=c377c7e042b1421091e98f2107692809&sidoCode=11&sggCode=";

        ArrayNode combinedKinderInfo=objectMapper.createArrayNode();
        try {
            for(String sggCode:sggCodes){
                String url=key+sggCode;
                String response=restTemplate.getForObject(url, String.class);

                JsonNode rootNode= objectMapper.readTree(response);

                //kinderInfo 추출
                JsonNode kinderInfoArray=rootNode.get("kinderInfo");
                if(kinderInfoArray!=null&&kinderInfoArray.isArray()){
                    kinderInfoArray.forEach(combinedKinderInfo::add);
                }
            }
            ObjectNode resultNode=objectMapper.createObjectNode();
            resultNode.put("status","SUCCESS");
            resultNode.set("kinderInfo",combinedKinderInfo);

            return ResponseEntity.ok(resultNode.toString());
        }
        catch (RestClientException | IllegalStateException | JsonProcessingException e) {
            System.err.println("API 오류발생 : "+e.getMessage());
            e.fillInStackTrace();
            return ResponseEntity.status(500).body("API 호출 실패 : "+e.getMessage());
        }
        catch (Exception e) {
            e.fillInStackTrace();
            return ResponseEntity.status(500).body("처리 중 오류 발생 : " + e.getMessage());
        }


    }

}
