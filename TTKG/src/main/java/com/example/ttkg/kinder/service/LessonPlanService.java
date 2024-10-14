package com.example.ttkg.kinder.service;

import com.example.ttkg.kinder.model.LessonPlanEntity;
import com.example.ttkg.kinder.repository.LessonPlanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LessonPlanService {

    LessonPlanRepository lessonPlanRepository;
    public LessonPlanService(LessonPlanRepository lessonPlanRepository) {
        this.lessonPlanRepository = lessonPlanRepository;
    }

    public List<LessonPlanEntity> getLessonPlansBetweenDate(String kinderCode,LocalDate start, LocalDate end) {

        return lessonPlanRepository.findAllByKinderCodeAndLessonDateBetween(kinderCode,start,end);
    }


}
