package com.example.ttkg.user.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentsDTO {


    @NotBlank(message = "아이디를 입력해주십시오.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$",message = "4~12자리의 영문과 숫자로 구성해주십시오")
    private String loginId;
    @Pattern(regexp ="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;
    @NotBlank(message = "비밀번호확인을 입력해 주십시오")
    private String confirmPassword;
    @NotBlank(message = "이메일을 입력해 주십시오")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$",message = "닉네임은 특수문자를 포함하지않는 2~10글자로 구성해주십시오.")
    private String email;
    @NotBlank(message = "별명을 입력해 주십시오")
    private String nickname;
    @NotBlank(message = "성함을 입력해 주십시오.")
    private String name;


}
