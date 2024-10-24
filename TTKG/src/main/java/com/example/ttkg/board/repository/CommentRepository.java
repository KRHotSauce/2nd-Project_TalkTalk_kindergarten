package com.example.ttkg.board.repository;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardIdx(Board board);
    void deleteAllByBoardIdx(Board board);
}
