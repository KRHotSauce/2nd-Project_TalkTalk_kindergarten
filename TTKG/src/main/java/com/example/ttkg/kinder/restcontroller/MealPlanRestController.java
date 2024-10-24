package com.example.ttkg.kinder.restcontroller;


import com.example.ttkg.kinder.model.MealPlanEntity;
import com.example.ttkg.kinder.service.MealPlanService;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meal_plans")
public class MealPlanRestController {

    private final MealPlanService mealPlanService;

    public MealPlanRestController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }
//    @GetMapping("/test")
//    public Map<String,String> getDataTest(){
//        Map<String,String> data = new HashMap<>();
//        data.put("message","Hello good Test");
//        data.put("status","success");
//        return data;
//    }


    @GetMapping("/kinder/{kinderCode}")
    public List<MealPlanEntity> getMealPlansOfMonthly(
            @PathVariable(value = "kinderCode") String kinderCode,
            @RequestParam(value = "startDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(value = "endDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate end) {
        System.out.println("컨트롤러 실행중 kinderCode : "+kinderCode);
        System.out.println("날짜 정보 : "+start);

        return mealPlanService.getMealPlanMonthly(kinderCode,start,end);
    }


}
