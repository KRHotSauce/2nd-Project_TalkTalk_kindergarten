package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.UserDTO;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
    }

    //dto를 받아 entity로 변환
    public UserEntity convertToEntityFromDTO(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserIdx(userDTO.getUserIdx());
        userEntity.setLoginId(userDTO.getLoginId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserNickname(userDTO.getUserNickname());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserKind(userDTO.getUserKind()==1);
        userEntity.setResiDate(userDTO.getResiDate());
        return userEntity;
    }
    /**Entity를 받아 DTO로 변환*/
    public UserDTO convertToDTOFromEntity(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        String encryptedPassword=passwordEncoder.encode(userEntity.getPassword());
        userDTO.setUserIdx(userEntity.getUserIdx());
        userDTO.setLoginId(userEntity.getLoginId());
        userDTO.setPassword(encryptedPassword);
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserNickname(userEntity.getUserNickname());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserKind(userEntity.isUserKind() ? 1 : 0);
        userDTO.setResiDate(userEntity.getResiDate());
        return userDTO;
    }

    /**
     * 회원가입 서비스
     */
    public void RegisterUserService(UserDTO userDTO) {

        //아이디,닉네임,이메일 중복검사
        if (    !userRepository.existsByLoginId(userDTO.getLoginId()) &&
                !userRepository.existsByUserNickname(userDTO.getUserNickname()) &&
                !userRepository.existsByUserEmail(userDTO.getUserEmail())
        )
        //비밀번호 암호화 및 DB에 저장
        {
            String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
            userDTO.setPassword(encryptedPassword);
            UserEntity userEntityRegister = new UserEntity();
            userEntityRegister.setLoginId(userDTO.getLoginId());
            userEntityRegister.setPassword(userDTO.getPassword());
            userEntityRegister.setUserEmail(userDTO.getUserEmail());
            userEntityRegister.setUserNickname(userDTO.getUserNickname());
            userEntityRegister.setUserName(userDTO.getUserName());
            userEntityRegister.setUserKind(userDTO.getUserKind()==1);
            userEntityRegister.setResiDate(LocalDateTime.now()); //등록날짜 저장
            userRepository.save(userEntityRegister);//DB에 회원가입 저장
        }
    }
    /**유저 아이디 존재하는지 확인, 아이디로 패스워드 비교, 로그인 하는 메서드
     * 맞으면 트루 반환*/
    public boolean CheckPasswordByLoginId(String loginId, String password) {
        //아이디 존재하는지 확인
        if(userRepository.existsByLoginId(loginId)){
            UserEntity userEntity = userRepository.findByLoginId(loginId)
                    .orElseThrow();
            return passwordEncoder.matches(password, userEntity.getPassword());
        }
        return false;
    }
    /**같은 유저존재확인 UserIdx로 구분*/
    public boolean CheckPasswordByUserIdx(long UserIdx, String password) {
       return passwordEncoder.matches(password, userRepository.findByUserIdx(UserIdx).getPassword());
    }

    /** UserIdx받아서 유저 DTO 뱉는 메서드*/
    public UserDTO getUserByUserIdx(long UserIdx) {
        UserEntity userEntity=userRepository.findByUserIdx(UserIdx);
        return convertToDTOFromEntity(userEntity);
    }

    /** 로그인시 로그인 아이디로 세션에 저장할 유저 로그인 DTO 뱉는 서비스*/
    public UserLoginDTO getUserLoginDTO(String loginId) {
        UserEntity userEntity = userRepository.findByLoginId(loginId).orElseThrow();
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUserIdx(userEntity.getUserIdx());
        userLoginDTO.setUserNickname(userEntity.getUserNickname());
        return userLoginDTO;
    }

    /*유저 정보 업데이트 서비스*/
    public void updateUser(UserDTO userDTO) {
        if (userRepository.existsByUserIdx(userDTO.getUserIdx())) {
            System.out.println("서비스 실행됨");
            userRepository.save(convertToEntityFromDTO(userDTO));
        }
    }

    /*이메일과 이름으로 유저 로그인 아이디 찾기 서비스*/
    public String findUserLoginIdByUserNameAndUserEmail(String userName, String userEmail) {
        UserEntity userEntity = userRepository.findUserLoginIdByUserNameAndUserEmail(userName, userEmail)
                .orElseThrow(() ->new IllegalArgumentException("입력한 정보와 일치하는 계정이 존재하지 않습니다"));

        return userEntity.getLoginId();
    }
    /** 임시 비밀번호 생성 후 저장*/
    public void logicTemporaryPassword(String LoginId){
        UserEntity userEntity=userRepository.findByLoginId(LoginId)
                .orElseThrow(()->new IllegalArgumentException("아이디가 존재하지 않습니다."));
        //비밀번호 생성 및 암호화 후 DB업데이트
        String tempPassword=new PasswordGenerator().generatePassword();
        userEntity.setPassword(passwordEncoder.encode(tempPassword));
        userRepository.save(userEntity);

        //이메일 발송
        sendMailPassword(userEntity.getUserEmail(),tempPassword);

    }
    private void sendMailPassword(String userEmail,String tempPassword){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("톡톡유치원 임시비밀번호 발송");
        message.setText("임시 비밀번호 : "+tempPassword+"\r\n"+"로그인 후 비밀번호를 꼭 다시 바꿔주시기 바랍니다.");
        message.setFrom("hstak41@gmail.com");
        mailSender.send(message);
    }

    public boolean checkExistByLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }
    public boolean checkExistByUserNickname(String userNickname) {
        return userRepository.existsByUserNickname(userNickname);
    }




}

/**임시비밀번호 생성 설정 클래스 8자리 특문+숫자+영문*/
class PasswordGenerator {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // 영문
    private static final String DIGITS = "0123456789"; // 숫자
    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+=<>?"; // 특수문자
    private static final SecureRandom random = new SecureRandom();

    public String generatePassword() {
        StringBuilder password = new StringBuilder();

        // 각 그룹에서 최소 하나씩 추가
        password.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // 나머지 자리수 채우기 (총 8자리)
        String allChars = LETTERS + DIGITS + SPECIAL_CHARS;
        for (int i = 3; i < 8; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // 비밀번호 랜덤하게 섞기 (각 유형이 섞이도록)
        List<Character> passwordChars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            passwordChars.add(c);
        }
        Collections.shuffle(passwordChars);

        StringBuilder finalPassword = new StringBuilder();
        for (char c : passwordChars) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }


}
