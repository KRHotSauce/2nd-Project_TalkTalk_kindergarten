package com.example.ttkg.user.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
    private Long userIdx;
    private String userNickname;
    private String KinderCode;
    private boolean userKind;

}
