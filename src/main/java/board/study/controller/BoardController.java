package board.study.controller;

import board.study.boardDTO.BoardDTO;
import board.study.service.BoardService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/board/openRegister")
    public void openRegister(Model model) {
        log.info("단순히 글을 등록하는 페이지 열어주는것");
    }

    @PostMapping("/board/register")
    public String register(BoardDTO boardDTO) {
        log.info("등록요청");
        log.info(boardDTO);
        boardService.boardServiceRegister(boardDTO);
        return  "redirect:/board/list";
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

    @PostMapping("/board/update")
    public String update(BoardDTO boardDTO ,Model model){
        log.info("수정요청");
        log.info(boardDTO);
        boardService.boardServiceUpdate(boardDTO);
        model.addAttribute("boardDetail",boardService.boardServiceViewDetail(boardDTO.getBno()));
        log.info(boardService.boardServiceViewDetail(boardDTO.getBno()));
        return  "redirect: /board/viewDetail/"+boardDTO.getBno();
    }

}
