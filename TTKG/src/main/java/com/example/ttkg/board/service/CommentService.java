package com.example.ttkg.board.service;

import com.example.ttkg.board.Dto.CommentCreateRequest;
import com.example.ttkg.board.Dto.CommentDto;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.Comment;
import com.example.ttkg.board.repository.BoardRepository;
import com.example.ttkg.board.repository.CommentRepository;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Comment writeComment(CommentCreateRequest req) {
        Board board = boardRepository.findById(req.getBoardIdx()).get();
        UserEntity user = userRepository.findByUserIdx(req.getUserIdx());
        /*board.commentChange(board.getCommentCnt() + 1);*/
        commentRepository.save(req.toEntity(board, user));
        return req.toEntity(board, user);
    }

    public List<CommentDto> findAll(Long boardIdx){
        List<Comment> comments = commentRepository.findAllByBoardIdx(boardRepository.findById(boardIdx).get());

        Set<Long> userIds = comments.stream()
                .map(Comment::getUserIdx)
                .collect(Collectors.toSet());

        Map<Long, String> userNames = userRepository.findByUserIdxIn(userIds).stream()
                .collect(Collectors.toMap(UserEntity::getUserIdx, UserEntity::getUserName));

        return comments.stream()
                .sorted(Comparator.comparing(Comment::getLastModifiedAt))  // 수정된 날짜 기준 정렬
                .map(comment -> CommentDto.of(comment,
                        userNames.get(comment.getUserIdx()),  // 유저 이름 매핑
                        comment.getLastModifiedAt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"))))  // 포맷팅된 날짜
                .toList();
    }



}
