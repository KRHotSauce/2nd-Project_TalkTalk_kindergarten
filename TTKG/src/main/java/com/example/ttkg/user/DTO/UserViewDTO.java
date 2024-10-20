package com.example.ttkg.user.DTO;

import com.example.ttkg.user.model.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserViewDTO {

    private Long userIdx;
    private String userEmail;
    private String userName;
    private String userNickname;

    public static UserViewDTO of(UserEntity user){

        return UserViewDTO.builder()
                .userIdx(user.getUserIdx())
                .userEmail(user.getUserEmail())
                .userName(user.getUserName())
                .userNickname(user.getUserNickname())
                .build();
    }

}
