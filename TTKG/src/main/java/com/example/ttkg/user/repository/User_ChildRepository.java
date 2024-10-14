package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.model.User_Child_Idx;
import com.example.ttkg.user.model.User_ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_ChildRepository extends JpaRepository<User_ChildEntity, User_Child_Idx> {
    boolean existsById(User_Child_Idx user_child_idx);
    boolean existsByUsers(UserEntity userEntity);
    List<User_ChildEntity> findByUsers(UserEntity userEntity);

}
