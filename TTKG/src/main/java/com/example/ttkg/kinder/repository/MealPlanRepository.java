package com.example.ttkg.kinder.repository;

import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.model.MealPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlanEntity, Long> {
    List<MealPlanEntity> findAllByKinderCodeAndMealDateBetween(String kinderCode, LocalDate start, LocalDate end);
    List<MealPlanEntity> findAllByMealDateBetween(LocalDate start, LocalDate end);
}
