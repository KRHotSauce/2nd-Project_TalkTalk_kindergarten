package com.example.ttkg.kinder.controller;

import com.example.ttkg.kinder.DTO.KinderDTO;
import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.service.KinderService;
import com.example.ttkg.user.DTO.ApplyKinderDTO;
import com.example.ttkg.user.service.User_ChildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KinderRestController {

    private final KinderService kinderService;
    private final User_ChildService user_childService;

    public KinderRestController(KinderService kinderService, User_ChildService user_childService) {
        this.kinderService = kinderService;
        this.user_childService = user_childService;
    }

    // 유치원 검색 API
    @GetMapping("/searchKinder")
    public ResponseEntity<List<KinderEntity>> searchKinder(@RequestParam("query") String query) {
        List<KinderEntity> kinderList = kinderService.searchKinderByName(query);  // 검색어로 유치원 검색
        return ResponseEntity.ok(kinderList);
    }

    @PostMapping("/applyKinder")
    public ResponseEntity<String> applyKinder(@RequestBody ApplyKinderDTO applyKinderDTO) {
        // 유치원 신청 처리 로직

        long childIdx= applyKinderDTO.getChildIdx();
        KinderEntity kinder= applyKinderDTO.getKinder();

        System.out.println("신청한 유치원: " + kinder.getKinderName() + ", 주소: " + kinder.getAddr() +
                "유치원 코드 : "+kinder.getKinderCode());

        // 신청 처리 로직
        user_childService.applyKinder(childIdx,kinder.getKinderCode());



        return ResponseEntity.ok("신청이 성공적으로 처리되었습니다.");
    }
}

