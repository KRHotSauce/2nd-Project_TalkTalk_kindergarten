package com.example.ttkg.root.Controller;

import com.example.ttkg.kinderFinder.api.KinderAPiService;
import com.example.ttkg.user.DTO.UserLoginDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    private final KinderAPiService kinderAPiService;

    public RootController(KinderAPiService kinderAPiService) {
        this.kinderAPiService = kinderAPiService;
    }

    @GetMapping("/ErrorPage")
    public String ErrorPage() {

        return "root/ErrorPage";
    }

    @GetMapping("/")
    public String RootPage(HttpSession session) {
//        UserLoginDTO loginDTO = new UserLoginDTO();
//        loginDTO.setUserIdx((long)41);
//        loginDTO.setUserNickname("테스트선생님");
//        loginDTO.setUserKind(false);
//        loginDTO.setKinderCode("K001");
//        session.setAttribute("userLoginDTO", loginDTO); //테스트용 자동로그인

        try {
            kinderAPiService.processGetKinderDataMultiple();
            System.out.println("유치원 API 성공");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("유치원 API 실패");
        }

        return "/index";
    }


}
