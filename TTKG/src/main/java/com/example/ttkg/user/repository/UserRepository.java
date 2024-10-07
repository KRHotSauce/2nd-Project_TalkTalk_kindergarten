package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByUserNickname(String UserNickname);
    boolean existsByUserEmail(String UserEmail);
    boolean existsByUserId(Long UserId);
    Optional<UserEntity> findByLoginId(String loginId);
    UserEntity findByUserId(Long userId);
    Optional<UserEntity> findUserLoginIdByUserNameAndUserEmail(String userName, String userEmail);
    Optional<UserEntity> findByUserEmail(String userEmail);
}

