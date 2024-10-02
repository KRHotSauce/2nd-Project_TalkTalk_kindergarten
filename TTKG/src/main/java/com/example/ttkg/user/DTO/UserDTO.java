package com.example.ttkg.user.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "아이디를 입력해주십시오.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "4~20자리의 영문과 숫자로 구성해주십시오.")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해 주십시오.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문, 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호를 입력해 주십시오.")
    private String confirmPassword;

    @NotBlank(message = "이메일을 입력해 주십시오.")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "올바른 이메일 형식이 아닙니다.")
    @Email
    private String userEmail;

    @NotBlank(message = "별명을 입력해 주십시오.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$", message = "닉네임은 특수문자를 포함하지 않는 2~10글자로 구성해주십시오.")
    private String userNickname;

    @NotBlank(message = "성함을 입력해 주십시오.")
    private String userName;

    @NotBlank
    @Pattern(regexp = "^[TP]")
    private String userKind;

    private LocalDateTime resiDate;
    private String profileImg;
    private boolean verified;
}

