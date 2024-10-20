package com.example.ttkg.user.DTO;

import com.example.ttkg.kinder.model.KinderEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyKinderDTO {

    private Long childIdx;
    private KinderEntity kinder;

}
