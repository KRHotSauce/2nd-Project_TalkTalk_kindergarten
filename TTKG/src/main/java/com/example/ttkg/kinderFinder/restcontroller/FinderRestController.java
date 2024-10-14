package com.example.ttkg.kinderFinder.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/kinder-finder")
public class FinderRestController {

    @GetMapping("/init")
    public ResponseEntity<String> getKinderInfo(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://e-childschoolinfo.moe.go.kr/api/notice/basicInfo.do?key=c377c7e042b1421091e98f2107692809&sidoCode=11&sggCode=11110";
        String response;
        try {
            response=restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        }
        catch (RestClientException e){
            System.err.println("API 오류발생 : "+e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("API 호출 실패 : "+e.getMessage());
        }


    }

}
