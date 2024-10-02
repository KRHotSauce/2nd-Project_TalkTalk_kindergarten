package com.example.ttkg.user.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
    private Long userId;
    private String userNickname;

}
