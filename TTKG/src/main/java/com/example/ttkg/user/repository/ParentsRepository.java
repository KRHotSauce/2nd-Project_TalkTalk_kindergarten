package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.ParentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentsRepository extends JpaRepository<ParentsEntity, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    Optional<ParentsEntity> findByLoginId(String loginId);
}
