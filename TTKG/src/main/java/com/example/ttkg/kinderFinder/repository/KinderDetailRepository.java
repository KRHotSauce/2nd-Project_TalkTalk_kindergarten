package com.example.ttkg.kinderFinder.repository;

import com.example.ttkg.kinderFinder.model.KinderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KinderDetailRepository extends JpaRepository<KinderDetailEntity,String> {
    
}
