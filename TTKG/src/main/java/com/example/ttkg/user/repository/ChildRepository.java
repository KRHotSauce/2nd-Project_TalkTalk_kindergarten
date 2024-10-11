package com.example.ttkg.user.repository;

import com.example.ttkg.user.model.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<ChildEntity,Long> {

}
