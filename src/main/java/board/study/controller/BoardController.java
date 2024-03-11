package board.study.controller;

import board.study.boardDTO.BoardDTO;
import board.study.boardDTO.PageDTO;
import board.study.boardDTO.PagebarDTO;
import board.study.service.BoardService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@Log4j
public class BoardController {

    @Autowired
    BoardService boardService;


    @GetMapping("/board/list")
    public void list(Model model, PageDTO pageDTO) {
        log.info("list url 요청");
        log.info(pageDTO);
        // URL의 파라미터가 없어도 pageDTO 기본값은 1페이지 10개씩
//        model.addAttribute("boardList",boardService.boardServiceList()); //
        model.addAttribute("boardList",boardService.boardServicePage(pageDTO)); //1페이지 내용 //문제없음
        model.addAttribute("pagebar",new PagebarDTO(pageDTO,boardService.boardServiceBnoCount())); //페이지바 //문제생김
        model.addAttribute("notSearch",true);

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
    public String viewDetail(@PathVariable Long bno, Model model, Principal principal ) {
        log.info("상세보기 페이지 요청");
        log.info(bno);
        model.addAttribute("boardDetail",boardService.boardServiceViewDetail(bno));
        if(principal != null) {
            model.addAttribute("username", principal.getName());
        }
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

    @GetMapping("/board/update")
    public String update(BoardDTO boardDTO ,Model model){
        log.info("수정요청");
        log.info(boardDTO);
        boardService.boardServiceUpdate(boardDTO);
        model.addAttribute("boardDetail",boardService.boardServiceViewDetail(boardDTO.getBno()));
        log.info(boardService.boardServiceViewDetail(boardDTO.getBno()));
        return  "redirect: /board/viewDetail/"+boardDTO.getBno();
    }

    @GetMapping("/board/search")
    public String search(String searchWord , String type ,Model model ,PageDTO pageDTO){
        log.info("검색된것");
        log.info(searchWord+type);
        log.info(pageDTO);
//        model.addAttribute("boardList",boardService.boardServiceSearchList(searchWord,type));
        model.addAttribute("boardList",boardService.boardServiceBoardSearchPage(searchWord,type,pageDTO));
        PagebarDTO pagebarDTO=new PagebarDTO(pageDTO,boardService.boardServiceboardSearchBnoCount(searchWord,type));
        model.addAttribute("pagebar",pagebarDTO); //페이지바 //문제생김
        model.addAttribute("search",true);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("type",type);
        return  "/board/list";
    }

}
