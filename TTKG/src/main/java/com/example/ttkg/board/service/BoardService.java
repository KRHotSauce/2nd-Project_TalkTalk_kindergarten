package com.example.ttkg.board.service;

import com.example.ttkg.board.Dto.BoardCreateRequest;
import com.example.ttkg.board.Dto.BoardDto;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import com.example.ttkg.board.repository.BoardRepository;
import com.example.ttkg.board.repository.CommentRepository;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public void write(Board board){
        boardRepository.save(board);
    }

    // 글 작성날짜가 오늘과 같으면 시간만 아니면 날짜만 표시하는 메서드
    public String formatBoardDate(Board board) {
        LocalDateTime createdAt = board.getCreatedAt();

        // 오늘 날짜인지 확인
        if (createdAt.toLocalDate().isEqual(LocalDate.now())) {
            // 오늘 날짜인 경우 시간만 표시
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            return createdAt.format(timeFormatter);
        } else {
            // 다른 날짜인 경우 날짜만 표시
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return createdAt.format(dateFormatter);
        }
    }

    @Transactional
    public Long writeBoard(BoardCreateRequest req, BoardCategory category, Long userIdx) throws IOException {
        /*UserEntity loginUser = userRepository.findByUserId(loginId);*/
        UserEntity user = userRepository.findByUserIdx(userIdx);
        Board savedBoard = boardRepository.save(req.toEntity(user));

        return savedBoard.getBoardIdx();
    }

    public Page<BoardDto> getBoardList(BoardCategory category, PageRequest pageRequest, String searchType, String keyword) {
        if (searchType != null && keyword != null) {
            /*if (searchType.equals("title")) {
                return boardRepository.findAllByCategoryAndTitle(category, keyword, pageRequest);
            } else {
                return boardRepository.findAllByCategoryAndUserNickname(category, keyword, pageRequest);
            }*/
        }
        if(category == BoardCategory.of("ALL")){
            Page<Board> boardList = boardRepository.findAll(pageRequest);
            return boardList.map(BoardDto::of);
        }
        Page<Board> boardList = boardRepository.findAllByCategory(category, pageRequest);
        return boardList.map(BoardDto::of);
    }


    public List<BoardDto> boardDtoList(){
        List<Board> boardEntitise = boardRepository.findAll();


        return boardEntitise.stream()
                .map(BoardDto::of)
                .collect(Collectors.toList());
    }

    public BoardDto boardRead(Long id){
        Board board = boardRepository.findById(id).get();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return BoardDto.of(board);
    }

    public void boardDelete(Long boardIdx){
        boardRepository.deleteById(boardIdx);
    }

    @Transactional
    public void boardEdit(BoardCreateRequest req){
        Optional<Board> optBoard = boardRepository.findById(req.getBoardIdx());
        Board board = optBoard.get();
        board.update(req);
    }


}
