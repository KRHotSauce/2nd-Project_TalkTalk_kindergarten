package com.example.ttkg.board.controller;

import com.example.ttkg.board.Dto.BoardCreateRequest;
import com.example.ttkg.board.Dto.BoardDto;
import com.example.ttkg.board.Dto.BoardSearchRequest;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import com.example.ttkwg.board.service.BoardService;
import com.example.ttkg.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


@Controller
public class boardController {

    private UserService userService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/main")
    public String getAllContents(Model model,
                                 @RequestParam(value = "category", defaultValue = "FREE")String category,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "sortType", required = false) String sortType,
                                 @RequestParam(value = "searchType", required = false) String searchType,
                                 @RequestParam(value = "keyword", required = false) String keyword) {
        BoardCategory boardCategory = BoardCategory.of(category);
        if (boardCategory == null) {
            model.addAttribute("message", "카테고리가 존재하지 않습니다.");
            model.addAttribute("nextUrl", "/");
            return "printMessage";
        }

        PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by("boardIdx").descending());
        if (sortType != null) {
            if (sortType.equals("date")) {
                pageRequest = PageRequest.of(page - 1, 10, Sort.by("createdAt").descending());
            } else if (sortType.equals("comment")) {
                pageRequest = PageRequest.of(page - 1, 10, Sort.by("commentCnt").descending());
            }
        }

        model.addAttribute("category", category);
        model.addAttribute("boards", boardService.getBoardList(boardCategory, pageRequest, searchType, keyword));
        model.addAttribute("boardSearchRequest", new BoardSearchRequest(sortType, searchType, keyword));
        return "board/boardMain";
    }


    @GetMapping("/board/write")
    public String toWritePage(Model model, @RequestParam(value = "category", defaultValue = "FREE")String category) {
        BoardCategory boardCategory = BoardCategory.of(category);
        if (boardCategory == null) {
            model.addAttribute("message", "카테고리가 존재하지 않습니다.");
            model.addAttribute("nextUrl", "/");
            return "printMessage";
        }

        /*model.addAttribute("message", savedBoardId + "번 글이 등록되었습니다.");
        model.addAttribute("nextUrl", "/boards/" + category + "/" + savedBoardId);*/
        model.addAttribute("category", category);
        model.addAttribute("boardCreateRequest", new BoardCreateRequest());

        return "board/write";
    }

    @PostMapping("/write_pro")
    public String writeProPage(@ModelAttribute BoardCreateRequest req, Model model, Board board,
                               @RequestParam(value = "category", defaultValue = "FREE")String category) throws IOException {
        BoardCategory boardCategory = BoardCategory.of(category);

        if (boardCategory == null) {
            model.addAttribute("message", "카테고리가 존재하지 않습니다.");
            model.addAttribute("nextUrl", "/");
            return "printMessage";
        }

        Long savedBoardId = boardService.writeBoard(req, boardCategory);
        return "redirect:board/read?boardIdx=" + savedBoardId;
    }

    @GetMapping("/modify")
    public String toModifyPage(Model model) {

        return "board/modify";
    }

    @GetMapping("/board/read")
    public String toReadPage(Model model, @RequestParam(value = "boardIdx") Long boardIdx) {
        model.addAttribute("content", boardService.boardRead(boardIdx));
        return "board/read";
    }


}
