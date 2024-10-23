package com.example.ttkg.user.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {



    private Long userIdx;

    @NotBlank(message = "아이디를 입력해주십시오.")
    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9]{3,19}$", message = "4~20자리의 영문과 숫자로 구성해주십시오.")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해 주십시오.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*+=-]).{8,15}$",
            message = "비밀번호는 영문, 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 15자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "이메일을 입력해 주십시오.")
    @Pattern(regexp = "^[0-9a-zA-Z]([-.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,}$", message = "올바른 이메일 형식이 아닙니다.")
    @Email
    private String userEmail;

    @NotBlank(message = "별명을 입력해 주십시오.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$", message = "닉네임은 특수문자를 포함하지 않는 2~10글자로 구성해주십시오.")
    private String userNickname;


    @NotBlank(message = "성함을 입력해 주십시오.")
    @Pattern(regexp = "^[가-힣a-zA-Z]+$",message="이름 오류")
    private String userName;

    String kinderCode;

    @NotNull
    @Min(0)
    @Max(1)
    private int userKind;

    private LocalDateTime resiDate;

}

