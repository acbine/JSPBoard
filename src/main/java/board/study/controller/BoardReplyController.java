package board.study.controller;

import board.study.boardDTO.ReplyDTO;
import board.study.service.ReplyService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j
@RestController
public class BoardReplyController {

    @Autowired
    ReplyService replyService;

    @GetMapping("/board/replyList")
    public ResponseEntity<List<ReplyDTO>> boardReplyList(Long bno){
        log.info("댓글리스트요청");
        List<ReplyDTO> boardReplyList=replyService.boardReplyList(bno);
        log.info(boardReplyList);
        return  new ResponseEntity<>(boardReplyList, HttpStatus.OK);
    }
}
