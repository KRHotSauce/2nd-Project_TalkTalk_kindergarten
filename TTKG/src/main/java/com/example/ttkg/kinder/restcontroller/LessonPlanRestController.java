package com.example.ttkg.kinder.restcontroller;

import com.example.ttkg.kinder.model.LessonPlanEntity;
import com.example.ttkg.kinder.service.LessonPlanService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lesson_plan")
public class LessonPlanRestController {

    LessonPlanService lessonPlanService;
    public LessonPlanRestController(LessonPlanService lessonPlanService) {
        this.lessonPlanService = lessonPlanService;
    }

    @GetMapping("kinder/{kinderCode}")
    public List<LessonPlanEntity> getLessonPlan(@PathVariable String kinderCode,
                                                @RequestParam(value = "startDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDate start,
                                                @RequestParam(value = "endDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDate end) {
        return lessonPlanService.getLessonPlansBetweenDate(kinderCode,start,end);
    }
}
