package com.example.ttkg.kinderInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinderInfoController {

    @GetMapping("/kinderInfoMain")
    public String kinderInfoMain() {
        return "kinderInfo/kinderInfo_main";
    }

    @GetMapping("/kinderInfoDetail")
    public String kinderInfoDetail() {
        return "kinderInfo/kinderInfo_detail";
    }

}
