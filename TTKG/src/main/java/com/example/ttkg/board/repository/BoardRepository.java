package com.example.ttkg.board.repository;

import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findAllByCategory(BoardCategory category, PageRequest pageRequest);
    /*Page<Board> findAllByCategoryAndTitle(BoardCategory category, String title, PageRequest pageRequest);
    Page<Board> findAllByCategoryAndUserNickname(BoardCategory category, String name, PageRequest pageRequest);*/


}
