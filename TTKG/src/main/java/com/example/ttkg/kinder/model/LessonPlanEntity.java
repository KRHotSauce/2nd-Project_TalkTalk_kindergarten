package com.example.ttkg.kinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@SequenceGenerator(
        name = "LESSON_SEQ_GENERATOR",
        sequenceName = "LESSON_PLAN_MONTHLY_SEQ",
        initialValue = 1,
        allocationSize = 1

)
@Getter
@Setter
@Table(name="LESSON_PLAN_MONTHLY")
public class LessonPlanEntity {
    @Id
    @Column(name="LESSONPLAN_IDX")
    long LessonPlanIdx;
    @Column(name="KINDERCODE")
    String kinderCode;
    @Column(name="LESSON_DATE")
    LocalDate lessonDate;
    @Column(name="BODY")
    String body;

}
