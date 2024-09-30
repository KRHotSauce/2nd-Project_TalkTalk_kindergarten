package com.example.ttkg.user.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {

    private Long userId;

    @NotBlank(message = "아이디를 입력해주십시오.")
    private String loginId;

    private String nickname;

}
