package com.example.ttkg.kinder.repository;

import com.example.ttkg.kinder.model.NoticeLetterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeLetterRepository extends JpaRepository<NoticeLetterEntity,Long> {
    Page<NoticeLetterEntity> findAll(Pageable pageable);
}
