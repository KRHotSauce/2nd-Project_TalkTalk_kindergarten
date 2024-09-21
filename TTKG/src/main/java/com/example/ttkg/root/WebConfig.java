package com.example.ttkg.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.method.HandlerTypePredicate;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        // 모든 Controller의 앞에 /talktalkkindergarten 추가
//        configurer.addPathPrefix("talktalkkindergarten", HandlerTypePredicate.forAnnotation(RestController.class));
//    }
}
