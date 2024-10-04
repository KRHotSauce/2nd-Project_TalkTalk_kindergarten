package com.example.ttkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class TtkgApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/talktalkkinder");
        SpringApplication.run(TtkgApplication.class, args);
        System.out.println("실행중");
    }

}
