package com.example.ttkg.user.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ChildDTO {

    long child_idx;

    @NotBlank(message = "자녀의 이름을 입력해 주십시오.")
    String child_name;

    @NotBlank(message = "자녀의 생년월일을 입력해주십시오.")
    LocalDate child_birth;

}
