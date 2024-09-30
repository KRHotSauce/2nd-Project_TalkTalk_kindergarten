package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    Optional<UserEntity> findByLoginId(String loginId);
    void deleteByloginId(String loginId);
}
