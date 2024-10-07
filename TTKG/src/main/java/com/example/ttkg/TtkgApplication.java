package com.example.ttkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
=======
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
>>>>>>> boardFeature

@SpringBootApplication
@EnableJpaAuditing
public class TtkgApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/talktalkkinder");
        SpringApplication.run(TtkgApplication.class, args);
        System.out.println("실행중");
    }

}
