package com.example.ttkg.user.service;

import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        //google 정보

        String email=oAuth2User.getAttribute("email");

        UserEntity user=userRepository.findByUserEmail(email).orElse(null);

        if(user==null) {
            UserEntity newUser=new UserEntity();
            newUser.setUserEmail(email);
            newUser.setAuthprovider(UserEntity.AuthProvider.GOOGLE);
            userRepository.save(newUser);

        }
        return oAuth2User;

    }


}
