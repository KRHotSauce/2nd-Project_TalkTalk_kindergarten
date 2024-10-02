package com.example.ttkg.root.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/ErrorPage")
    public String ErrorPage() {

        return "root/ErrorPage";
    }


}
