package com.example.ttkg.kinder.repository;

import com.example.ttkg.kinder.model.LessonPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LessonPlanRepository extends JpaRepository<LessonPlanEntity, Long> {
    List<LessonPlanEntity> findAllByKinderCodeAndLessonDateBetween(String kinderCode,LocalDate start, LocalDate end);
}
