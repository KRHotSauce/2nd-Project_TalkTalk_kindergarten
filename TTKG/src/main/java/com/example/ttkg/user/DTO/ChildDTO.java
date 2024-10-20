package com.example.ttkg.user.DTO;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.model.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Builder
public class ChildDTO {

    private Long childIdx;
    private String childName;
    private String childBirth;
    private Integer childAge;
    private String childAddr;
    private String childGender;
    private Boolean childAllergy;
    private String kinderCode;

    /*생년월일 이용해서 나이 계산
    kinderCode 있으면 유치원 정보 기입*/
    public static ChildDTO of(ChildEntity child) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedBirth = child.getChildBirth().format(formatter);
        Integer age = LocalDate.now().getYear() - child.getChildBirth().getYear() + 1;

        return ChildDTO.builder()
                .childIdx(child.getChildIdx())
                .childName(child.getChildName())
                .childBirth(formattedBirth)
                .childAge(age)
                .childAddr(child.getChildAddr())
                .childGender(child.getChildGender())
                .childAllergy(child.getChildAllergy())
                .build();
    }

}
