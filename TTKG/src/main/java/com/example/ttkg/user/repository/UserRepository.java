package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByUserNickname(String UserNickname);
    boolean existsByUserEmail(String UserEmail);
    UserEntity findByLoginId(String loginId);
    UserEntity findByUserId(Long userId);
}

