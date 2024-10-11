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
    boolean existsByUserIdx(Long UserIdx);
    Optional<UserEntity> findByLoginId(String loginId);
    UserEntity findByUserIdx(Long userIdx);
    Optional<UserEntity> findUserLoginIdByUserNameAndUserEmail(String userName, String userEmail);
    Optional<UserEntity> findByUserEmail(String userEmail);
}

