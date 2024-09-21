package com.example.ttkg.user.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentsLoginDTO {

    @NotBlank(message = "아이디를 입력해주십시오.")
    private String loginId;
    @NotBlank(message = "비밀번호를 입력해주십시오.")
    private String password;

}
