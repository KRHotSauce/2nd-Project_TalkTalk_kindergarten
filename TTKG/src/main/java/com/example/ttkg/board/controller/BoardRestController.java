package com.example.ttkg.board.controller;

import com.example.ttkg.board.Dto.BoardCreateRequest;
import com.example.ttkg.board.Dto.CommentCreateRequest;
import com.example.ttkg.board.Dto.CommentDto;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.Comment;
import com.example.ttkg.board.service.BoardService;
import com.example.ttkg.board.service.CommentService;
import com.example.ttkg.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final CommentService commentService;
    private final BoardService boardService;

    @PostMapping("/board/comment/write")
    public ResponseEntity<Comment> saveComment(@RequestBody CommentCreateRequest commentCreateRequest) {

        Comment savedCommentDto = commentService.writeComment(commentCreateRequest);
        return ResponseEntity.ok(savedCommentDto);
    }

    @GetMapping("/board/comment/read")
    public ResponseEntity<List<CommentDto>> getComments(@RequestParam(value = "boardIdx") Long boardIdx) {
        List<CommentDto> comments = commentService.findAll(boardIdx);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/board/delete")
    public void deleteBoard(@RequestParam(value = "boardIdx") Long boardIdx) {
        boardService.boardDelete(boardIdx);
    }



}
