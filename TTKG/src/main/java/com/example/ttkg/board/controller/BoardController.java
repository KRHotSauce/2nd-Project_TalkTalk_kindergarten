package com.example.ttkg.board.controller;

import com.example.ttkg.board.Dto.BoardCreateRequest;
import com.example.ttkg.board.Dto.BoardDto;
import com.example.ttkg.board.Dto.BoardSearchRequest;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import com.example.ttkg.board.repository.CommentRepository;
import com.example.ttkg.board.service.BoardService;
import com.example.ttkg.board.service.CommentService;
import com.example.ttkg.user.DTO.UserLoginDTO;
import com.example.ttkg.user.repository.UserRepository;
import com.example.ttkg.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private UserService userService;

    @Autowired
    private BoardService boardService;
    private final UserRepository userRepository;
    private final CommentService commentService;

    @GetMapping("/board/main")
    public String getAllContents(Model model,
                                 @RequestParam(value = "category", defaultValue = "FREE")String category,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "sortType", required = false, defaultValue = "idx_descend") String sortType,
                                 @RequestParam(value = "searchType", required = false) String searchType,
                                 @RequestParam(value = "keyword", required = false) String keyword) {
        BoardCategory boardCategory = BoardCategory.of(category);
        if (boardCategory == null) {
            model.addAttribute("message", "카테고리가 존재하지 않습니다.");
            model.addAttribute("nextUrl", "/");
            return "printMessage";
        }

        PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by("boardIdx").descending());  // 기본값으로 내림차순 정렬

        if (sortType != null) {
            pageRequest = switch (sortType) {
                case "date_descend" -> PageRequest.of(page - 1, 10, Sort.by("createdAt").descending());
                case "date_ascend" -> PageRequest.of(page - 1, 10, Sort.by("createdAt").ascending());
                case "idx_descend" -> PageRequest.of(page - 1, 10, Sort.by("boardIdx").descending());
                case "idx_ascend" -> PageRequest.of(page - 1, 10, Sort.by("boardIdx").ascending());
                default -> pageRequest;
            };
        }

        model.addAttribute("page", page);
        model.addAttribute("sortType", sortType);
        model.addAttribute("category", category);
        model.addAttribute("boards", boardService.getBoardList(boardCategory, pageRequest, searchType, keyword));
        model.addAttribute("boardSearchRequest", new BoardSearchRequest(sortType, searchType, keyword));
        return "board/boardMain";
    }


    @GetMapping("/board/write")
    public String toWritePage(Model model, @RequestParam(value = "category", defaultValue = "FREE")String category,
                              HttpSession session) {
        BoardCategory boardCategory = BoardCategory.of(category);
        if (boardCategory == null) {
            model.addAttribute("message", "카테고리가 존재하지 않습니다.");
            model.addAttribute("nextUrl", "/");
            return "printMessage";
        }

        /*model.addAttribute("message", savedBoardId + "번 글이 등록되었습니다.");
        model.addAttribute("nextUrl", "/boards/" + category + "/" + savedBoardId);*/
        UserLoginDTO userLoginDTO = (UserLoginDTO) session.getAttribute("userLoginDTO");
        model.addAttribute("author", userRepository.findByUserIdx(userLoginDTO.getUserIdx()).getUserName());
        model.addAttribute("category", category);
        model.addAttribute("boardCreateRequest", new BoardCreateRequest());

        return "board/write";
    }

    @PostMapping("/write_pro")
    public String writeProPage(@ModelAttribute BoardCreateRequest req, Model model, Board board,
                               HttpSession session) throws IOException {
        String category = "FREE";
        BoardCategory boardCategory = BoardCategory.of(category);
        if (boardCategory == null) {
            model.addAttribute("message", "카테고리가 존재하지 않습니다.");
            model.addAttribute("nextUrl", "/");
            return "printMessage";
        }
        System.out.println(req.getCategory());
        UserLoginDTO userLoginDTO = (UserLoginDTO) session.getAttribute("userLoginDTO");
        Long savedBoardId = boardService.writeBoard(req, boardCategory, userLoginDTO.getUserIdx());
        return "redirect:board/read?boardIdx=" + savedBoardId;
    }

    @GetMapping("/modify")
    public String toModifyPage(Model model) {

        return "board/modify";
    }

    @GetMapping("/board/read")
    public String toReadPage(Model model, @RequestParam(value = "boardIdx") Long boardIdx,
                             @RequestParam(value = "page", required = false, defaultValue = "1") Integer page, HttpSession session) {
        UserLoginDTO userLoginDTO = (UserLoginDTO) session.getAttribute("userLoginDTO");
        model.addAttribute("comments", commentService.findAll(boardIdx));
        model.addAttribute("user", userRepository.findByUserIdx(userLoginDTO.getUserIdx()));
        model.addAttribute("content", boardService.boardRead(boardIdx));
        return "board/read";
    }

    @GetMapping("/board/edit")
    public String editBoard(@RequestParam(value = "boardIdx") Long boardIdx, Model model){
        model.addAttribute("content", boardService.boardRead(boardIdx));
        model.addAttribute("boardCreateRequest", new BoardCreateRequest());
        return "board/edit";
    }

    @PostMapping("/edit_pro")
    public String doEditBoard(@ModelAttribute BoardCreateRequest req, Model model){
        boardService.boardEdit(req);
        return "redirect:board/read?boardIdx=" + req.getBoardIdx();
    }


}
