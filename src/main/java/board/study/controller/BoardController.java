package board.study.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class BoardController {
    @GetMapping("list")
    public void list() {
        log.info("list url 요청");

    }
}
