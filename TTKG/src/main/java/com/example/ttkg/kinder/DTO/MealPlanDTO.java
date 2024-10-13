package com.example.ttkg.kinder.DTO;


import com.example.ttkg.kinder.model.KinderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class MealPlanDTO {

    long mealIdx;

    String kinderCode;

    int kind;

    String mealInfo;

    String origin;

    LocalDate mealDate;
}
