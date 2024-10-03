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
    public UserEntity convertToEntityFromDTO(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLoginId(userDTO.getLoginId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserNickname(userDTO.getUserNickname());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserKind(userDTO.getUserKind());
        userEntity.setProfileImg(userDTO.getProfileImg());
        userEntity.setVerified(userDTO.isVerified());
        userEntity.setResiDate(userDTO.getResiDate());
        return userEntity;
    }
    public UserDTO convertToDTOFromEntity(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLoginId(userEntity.getLoginId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserNickname(userEntity.getUserNickname());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserKind(userEntity.getUserKind());
        userDTO.setProfileImg(userEntity.getProfileImg());
        userDTO.setVerified(userEntity.getVerified());
        userDTO.setResiDate(userEntity.getResiDate());
        return userDTO;
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
            userDTO.setPassword(encryptedPassword);
            UserEntity userEntityRegister = new UserEntity();
            userEntityRegister.setLoginId(userDTO.getLoginId());
            userEntityRegister.setPassword(userDTO.getPassword());
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
    /**유저 아이디 존재하는지 확인, 아이디로 패스워드 비교, 로그인 하는 메서드
     * 맞으면 트루 반환*/
    public boolean CheckPasswordByLoginId(String loginId, String password) {
        //아이디 존재하는지 확인
        if(userRepository.existsByLoginId(loginId)){
            UserEntity userEntity = userRepository.findByLoginId(loginId);
            return passwordEncoder.matches(password, userEntity.getPassword());
        }
        return false;
    }
    //같은 체크아이디 userId로 구분
    public boolean CheckPasswordByUserId(long userId, String password) {
       return passwordEncoder.matches(password, userRepository.findByUserId(userId).getPassword());
    }

    public UserDTO getUserByUserId(long userId) {
        UserEntity userEntity=userRepository.findByUserId(userId);
        return convertToDTOFromEntity(userEntity);
    }

    public UserLoginDTO getUserLoginDTO(String loginId) {
        UserEntity userEntity = userRepository.findByLoginId(loginId);
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUserId(userEntity.getUserId());
        userLoginDTO.setUserNickname(userEntity.getUserNickname());
        return userLoginDTO;
    }

}
