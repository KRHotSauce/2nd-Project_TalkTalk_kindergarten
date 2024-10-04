package com.example.ttkg.user.restcontroller;

import com.example.ttkg.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")  // 기본 경로를 설정하여 /api로 시작하도록
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // 아이디 중복 체크 API
    @GetMapping("/api/check_loginId")
    public boolean checkLoginId(@RequestParam("loginId") String loginId) {
        System.out.println("API ID 매핑 성공");
        return userService.checkExistByLoginId(loginId);
    }

    // 닉네임 중복 체크 API
    @GetMapping("/check-userNickname")
    public boolean checkUserNickname(@RequestParam("userNickname") String userNickname) {
        System.out.println("API 닉네임 매핑 성공 -------");
        return userService.checkExistByUserNickname(userNickname);
    }
}