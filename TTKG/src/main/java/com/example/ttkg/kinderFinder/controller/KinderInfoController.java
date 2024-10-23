package com.example.ttkg.kinderFinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinderInfoController {

    @GetMapping("finderMain")
    public String kinderInfoMain() {
        return "kinderFinder/finderMain";
    }

    @GetMapping("kinderDetail")
    public String kinderDetail() {
        return "kinderFinder/kinderDetail";
    }



}
