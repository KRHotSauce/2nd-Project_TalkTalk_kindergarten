package com.example.ttkg.board.service;

import com.example.ttkg.board.Dto.CommentCreateRequest;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.Comment;
import com.example.ttkg.board.repository.BoardRepository;
import com.example.ttkg.board.repository.CommentRepository;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Comment writeComment(CommentCreateRequest req) {
        Board board = boardRepository.findById(req.getBoardIdx()).get();
        UserEntity user = userRepository.findByUserId(req.getUserIdx());
        /*board.commentChange(board.getCommentCnt() + 1);*/
        commentRepository.save(req.toEntity(board, user));
        return req.toEntity(board, user);
    }

    public List<Comment> findAll(Long boardIdx){
        return commentRepository.findAllByBoardIdx(boardRepository.findById(boardIdx).get());
    }

}
