package com.example.ttkg.kinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name="meal_plan")
@SequenceGenerator(
        name="MEAL_SEQ_GENERATOR",
        sequenceName = "MEAL_PLAN_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
public class MealPlanEntity {

    @Id
    @Column(name="meal_idx")
            @GeneratedValue(
                    strategy = GenerationType.SEQUENCE,
                    generator = "MEAL_SEQ_GENERATOR"
            )
    long mealIdx;

    @Column(name="kindercode")
    String kinderCode;

    @Column(name="kind")
    int kind;

    @Column(name="meal_info")
    String mealInfo;

    @Column(name="origin")
    String origin;

    @Column(name="meal_date")
    LocalDate mealDate;

}
