package com.example.ttkg.kinder.service;

import com.example.ttkg.kinder.model.NoticeLetterEntity;
import com.example.ttkg.kinder.repository.NoticeLetterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NoticeLetterService {

    NoticeLetterRepository noticeLetterRepository;

    public NoticeLetterService(NoticeLetterRepository noticeLetterRepository) {
        this.noticeLetterRepository = noticeLetterRepository;
    }

    public Page<NoticeLetterEntity> getNoticeLetters(int currentPage) {
        Pageable pageable= PageRequest.of(currentPage-1, 10, Sort.by(Sort.Direction.DESC, "letterIdx"));
        //페이지 0부터 시작하므로 -1, 페이지 사이즈, 내림차순으로 정렬
        return noticeLetterRepository.findAll(pageable);
    }

}
