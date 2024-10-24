package com.example.ttkg.root.Controller;

import com.example.ttkg.board.Dto.BoardDto;
import com.example.ttkg.board.entity.Board;
import com.example.ttkg.board.entity.BoardCategory;
import com.example.ttkg.board.service.BoardService;
import com.example.ttkg.kinderFinder.api.KinderAPiService;
import com.example.ttkg.user.DTO.UserLoginDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RootController {

    @Autowired
    private BoardService boardService;
    private final KinderAPiService kinderAPiService;

    @GetMapping("/ErrorPage")
    public String ErrorPage() {

        return "root/ErrorPage";
    }

    @GetMapping("/")
    public String RootPage(HttpSession session, Model model) {
//        UserLoginDTO loginDTO = new UserLoginDTO();
//        loginDTO.setUserIdx((long)41);
//        loginDTO.setUserNickname("테스트선생님");
//        loginDTO.setUserKind(false);
//        loginDTO.setKinderCode("K001");
//        session.setAttribute("userLoginDTO", loginDTO); //테스트용 자동로그인

        try {
            kinderAPiService.processGetKinderDataMultiple();
            System.out.println("유치원 API 성공");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("유치원 API 실패");
        }

        PageRequest freePageRequest = PageRequest.of(0, 5, Sort.by("boardIdx").descending());
        PageRequest qnaPageRequest = PageRequest.of(0, 5, Sort.by("boardIdx").descending());

        Page<BoardDto> freeList = boardService.getBoardList(BoardCategory.of("free"), freePageRequest, "", "");
        Page<BoardDto> qnaList = boardService.getBoardList(BoardCategory.of("qna"), qnaPageRequest, "", "");

        model.addAttribute("freeList", freeList);
        model.addAttribute("qnaList", qnaList);

        return "/index";
    }


}
