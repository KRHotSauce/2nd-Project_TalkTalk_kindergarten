package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.User_Child_Idx;
import com.example.ttkg.user.model.User_childEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_ChildRepository extends JpaRepository<User_childEntity, User_Child_Idx> {
    boolean existsById(User_Child_Idx user_child_idx);
}
