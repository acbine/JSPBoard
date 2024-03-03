package board.study.controller;

import board.study.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Log4j
public class BoardController {

    @Autowired
    BoardService boardService;
    @GetMapping("/board/list")
    public void list(Model model) {
        log.info("list url 요청");
        model.addAttribute("boardList",boardService.boardServiceList());
    }

    @GetMapping("/board/viewDetail/{bno}")
    public String viewDetail(@PathVariable Long bno,Model model ) {
        log.info("상세보기 페이지 요청");
        log.info(bno);
        model.addAttribute("boardDetail",boardService.boardServiceViewDetail(bno));
        log.info(boardService.boardServiceViewDetail(bno));
        return  "/board/viewDetail";
    }

    @GetMapping("/board/delete/{bno}")
    public String delete(@PathVariable Long bno) {
        log.info("삭제 요청");
        log.info(bno);
        boardService.boardServiceDelete(bno);
        return  "redirect:/board/list";
    }
}
