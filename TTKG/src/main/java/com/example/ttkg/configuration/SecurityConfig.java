package com.example.ttkg.configuration;

import com.example.ttkg.user.repository.UserRepository;
import com.example.ttkg.user.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //스프링 시큐리티 설정 나중에 유치원 페이지는 로그인 전에 못 들어가도록 설정하기
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .csrf().disable();
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("login")
//                        .defaultSuccessUrl("/login/google-login_success", true)
//                        .permitAll()
//                        .userInfoEndpoint(userInfo->userInfo
//                                .userService(customOAuth2UserService())
//                        )
//                );
        return http.build();
    }

//    @Bean
//    public CustomOAuth2UserService customOAuth2UserService(){
//        return new CustomOAuth2UserService(userRepository);
//    }

}


