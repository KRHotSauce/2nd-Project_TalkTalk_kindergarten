package com.example.ttkg.kinder.repository;

import com.example.ttkg.kinder.model.KinderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KinderRepository extends JpaRepository<KinderEntity,String> {
    KinderEntity findByKinderCode(String kinderCode);
}
