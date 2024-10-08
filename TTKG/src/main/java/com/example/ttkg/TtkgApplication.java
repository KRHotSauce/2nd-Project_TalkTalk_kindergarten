package com.example.ttkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TtkgApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/talktalkkinder");
        SpringApplication.run(TtkgApplication.class, args);
        System.out.println("실행중");
    }
    //자녀 엔티티 등록로직차례

}
