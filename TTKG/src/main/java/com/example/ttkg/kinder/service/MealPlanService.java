package com.example.ttkg.kinder.service;

import com.example.ttkg.kinder.DTO.KinderDTO;
import com.example.ttkg.kinder.DTO.MealPlanDTO;
import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.model.MealPlanEntity;
import com.example.ttkg.kinder.repository.KinderRepository;
import com.example.ttkg.kinder.repository.MealPlanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MealPlanService {

    private final MealPlanRepository mealPlanRepository;
    private final KinderService kinderService;

    public MealPlanService(MealPlanRepository mealPlanRepository,KinderService kinderService) {
        this.mealPlanRepository = mealPlanRepository;
        this.kinderService = kinderService;
    }

    public MealPlanDTO setDTO(MealPlanEntity mealPlanEntity) {
        MealPlanDTO mealPlanDTO = new MealPlanDTO();
        mealPlanDTO.setMealIdx(mealPlanEntity.getMealIdx());
        mealPlanDTO.setMealInfo(mealPlanEntity.getMealInfo());
        mealPlanDTO.setMealDate(mealPlanEntity.getMealDate());
        mealPlanDTO.setOrigin(mealPlanEntity.getOrigin());
        mealPlanDTO.setKind(mealPlanEntity.getKind());
        mealPlanDTO.setKinderCode(mealPlanEntity.getKinderCode());
        return mealPlanDTO;
    }

   public List<MealPlanEntity> getMealPlanMonthly(String KinderCode, LocalDate start,LocalDate end){
        System.out.println("서비스 작동 kindercode : "+KinderCode);
        List<MealPlanEntity> mealPlanEntityList=mealPlanRepository.findAllByMealDateBetween(start, end);
        System.out.println(mealPlanEntityList.get(0).getMealInfo());
        return mealPlanEntityList;
   }


}
