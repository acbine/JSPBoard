package board.study.controller;

import board.study.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class BoardController {

    @Autowired
    BoardService boardService;
    @GetMapping("list")
    public void list(Model model) {
        log.info("list url 요청");
        model.addAttribute("boardList",boardService.boardServiceList());
    }
}
