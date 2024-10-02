package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.UserDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 회원가입 서비스
     */
    public void RegisterUserService(UserDTO userDTO) {

        //비밀번호 암호화

        if (    !userRepository.existsByLoginId(userDTO.getLoginId()) &&
                !userRepository.existsByUserNickname(userDTO.getUserNickname()) &&
                !userRepository.existsByUserEmail(userDTO.getUserEmail())
        ) //비밀번호 체크와 아이디,이메일,닉네임 중복인지 검사
        {
            String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
            UserEntity userEntityRegister = new UserEntity();
            userEntityRegister.setLoginId(userDTO.getLoginId());
            userEntityRegister.setPassword(encryptedPassword);
            userEntityRegister.setUserEmail(userDTO.getUserEmail());
            userEntityRegister.setUserNickname(userDTO.getUserNickname());
            userEntityRegister.setUserName(userDTO.getUserName());
            userEntityRegister.setUserKind(userDTO.getUserKind());
            userEntityRegister.setProfileImg(null);
            userEntityRegister.setVerified(false);
            userEntityRegister.setResiDate(LocalDateTime.now()); //등록날짜 저장
            userRepository.save(userEntityRegister);//DB에 회원가입 저장
        }
    }
    /**유저 아이디 존재하는지 확인, 아이디로 패스워드 비교, 로그인 하는 메서드*/
    public boolean LoginUserService(String loginId, String password) {
        //아이디 존재하는지 확인
        if(userRepository.existsByLoginId(loginId)){
            UserEntity userEntity = userRepository.findByLoginId(loginId);
            return passwordEncoder.matches(password, userEntity.getPassword());
        }
        return false;
    }

    public UserLoginDTO getUserLoginDTO(String loginId) {
        UserEntity userEntity = userRepository.findByLoginId(loginId);
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUserId(userEntity.getUserId());
        userLoginDTO.setUserNickname(userEntity.getUserNickname());
        return userLoginDTO;
    }

}
