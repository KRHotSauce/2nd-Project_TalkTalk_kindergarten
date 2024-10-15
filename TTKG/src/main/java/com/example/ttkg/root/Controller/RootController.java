package com.example.ttkg.root.Controller;

import com.example.ttkg.kinderFinder.api.KinderAPiService;
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
    public String RootPage() {

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
