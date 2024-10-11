package com.example.ttkg.kinder.service;

import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.model.MealPlanEntity;
import com.example.ttkg.kinder.repository.KinderRepository;
import com.example.ttkg.kinder.repository.MealPlanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealPlanService {

    private final MealPlanRepository mealPlanRepository;
    private final KinderRepository kinderRepository;

    public MealPlanService(MealPlanRepository mealPlanRepository, KinderRepository kinderRepository) {
        this.mealPlanRepository = mealPlanRepository;
        this.kinderRepository = kinderRepository;
    }

   public List<MealPlanEntity> getMealPlanMonthly(String KinderCode, LocalDate start,LocalDate end){
        System.out.println("서비스 작동 kindercode : "+KinderCode);
        KinderEntity kinderEntity=kinderRepository.findByKinderCode(KinderCode);
        System.out.println("kinderEntity : "+kinderEntity.getKinderCode());

        return mealPlanRepository.findByKinderCodeAndMealDateBetween(kinderEntity, start, end);
   }


}
