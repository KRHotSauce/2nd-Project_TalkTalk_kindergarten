package com.example.ttkg.board.controller;

import com.example.ttkg.board.Dto.CommentCreateRequest;
import com.example.ttkg.board.entity.Comment;
import com.example.ttkg.board.service.BoardService;
import com.example.ttkg.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final CommentService commentService;

    @PostMapping("/board/comment/write")
    public ResponseEntity<Comment> saveComment(@RequestBody CommentCreateRequest commentCreateRequest){

        Comment savedCommentDto = commentService.writeComment(commentCreateRequest);
        return ResponseEntity.ok(savedCommentDto);
    }

    @GetMapping("/board/comment/read")
    public ResponseEntity<List<Comment>> getComments(@RequestParam(value = "boardIdx") Long boardIdx) {
        List<Comment> comments = commentService.findAll(boardIdx);
        return ResponseEntity.ok(comments);
    }

}
