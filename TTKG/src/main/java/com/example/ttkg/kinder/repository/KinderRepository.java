package com.example.ttkg.kinder.repository;

import com.example.ttkg.kinder.model.KinderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KinderRepository extends JpaRepository<KinderEntity,String> {
//    @Query(value = "SELECT * FROM kinder WHERE kindercode = ?1", nativeQuery = true)
    Optional<KinderEntity> findByKinderCode(String kinderCode);
    List<KinderEntity> findByKinderNameContaining(String query);
}
