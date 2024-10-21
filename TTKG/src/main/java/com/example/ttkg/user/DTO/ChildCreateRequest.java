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
import java.util.Date;

@Data
public class ChildCreateRequest {

    private long child_idx;

    @NotBlank(message = "자녀의 이름을 입력해 주십시오.")
    private String child_name;

    @NotBlank(message = "자녀의 생년월일을 입력해주십시오.")
    private LocalDate child_birth;

    @NotBlank(message = "자녀의 주소를 입력해 주십시오.")
    private String child_addr;

    @NotBlank(message = "자녀의 성별을 입력해 주십시오.")
    private String child_gender;

    @NotBlank(message = "자녀의 알러지 여부를 입력해 주십시오.")
    private String child_allergy;

    public ChildEntity toEntity() {
        System.out.println(child_gender);
        if (child_gender.equals("Male")){
            child_gender = "M";
        }else {
            child_gender = "F";
        }
        return ChildEntity.builder()
                .childName(child_name)
                .childBirth(child_birth)
                .childAddr(child_addr)
                .childGender(child_gender)
                .childAllergy(child_allergy)
                .build();
    }

}
