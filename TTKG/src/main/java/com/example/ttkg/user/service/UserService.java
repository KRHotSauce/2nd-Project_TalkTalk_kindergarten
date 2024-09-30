package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.UserRegiDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerNewParent(UserRegiDTO userRegiDTO) {
        if(userRepository.existsByLoginId(userRegiDTO.getLoginId())) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
        if(userRepository.existsByEmail(userRegiDTO.getEmail())) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }
        if(userRepository.existsByNickname(userRegiDTO.getNickname())) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setLoginId(userRegiDTO.getLoginId());
        userEntity.setUserNickname(userRegiDTO.getNickname());
        userEntity.setUserEmail(userRegiDTO.getEmail());
        userEntity.setPassword(userRegiDTO.getPassword());
        userEntity.setUserName(userRegiDTO.getName());

        // userId는 설정하지 않음
        userEntity = userRepository.save(userEntity);

        return userEntity;

    }
    /**로그인 할때 아이디,비밀번호 여부 일치한다면 true 아니면 false 반환*/
    public boolean checkLogin(UserLoginDTO userLoginDTO){
        Optional<UserEntity> parents= userRepository.findByLoginId(userLoginDTO.getLoginId());
        if(parents.isPresent()) {
        UserEntity userEntity =parents.get();
        return userEntity.getPassword().equals(userLoginDTO); //수정필요
        }
        return false;
    }

    public boolean chekcPassword(UserLoginDTO userLoginDTO, String password){
        if(userLoginDTO.getPassword().equals(password))
            return true;
        else{
            return false;
        }
    }

    public UserRegiDTO getParentsEntitybyLoginID(String loginId){
        Optional<UserEntity> parents= userRepository.findByLoginId(loginId);
        UserRegiDTO userRegiDTO =new UserRegiDTO();
        if(parents.isPresent()) {
            userRegiDTO.setLoginId(parents.get().getLoginId());
            userRegiDTO.setNickname(parents.get().getNickname());
            userRegiDTO.setEmail(parents.get().getEmail());
            userRegiDTO.setPassword(parents.get().getPassword());
            userRegiDTO.setName(parents.get().getName());
        }
        return userRegiDTO;

    }

    public void UpdateParentsProfile(UserRegiDTO updatedUserRegiDTO, String loginId) {
        userRepository.findByLoginId(loginId)
                .ifPresent(userEntity -> {
                    userEntity.setNickname(updatedUserRegiDTO.getNickname());
                    userEntity.setEmail(updatedUserRegiDTO.getEmail());
                    userEntity.setPassword(updatedUserRegiDTO.getPassword());
                    userEntity.setName(updatedUserRegiDTO.getName());
                    userRepository.save(userEntity);

                });
    }

    @Transactional
    public void DeleteAccountMethod(String loginId) {
        userRepository.deleteByloginId(loginId);
    }

}
