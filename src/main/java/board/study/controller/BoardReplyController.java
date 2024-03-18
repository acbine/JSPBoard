package board.study.controller;

import board.study.boardDTO.PageDTO;
import board.study.boardDTO.PagebarDTO;
import board.study.boardDTO.ReplyDTO;
import board.study.memberDTO.MemberDTO;
import board.study.service.ReplyService;
import board.study.service.UserDetailsServiceImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Log4j
@RestController
public class BoardReplyController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    ReplyService replyService;

    @GetMapping("/board/replyList")
    public ResponseEntity<List<ReplyDTO>> boardReplyList(Long bno){
        
//        if (principal !=null) {
//            String userName=userDetailsService.selectMember(principal.getName()).getUserName();
//            log.info("++++++++++++로그인한사용자닉네임+++++++++++++++"+userName);
//        }

        log.info("댓글리스트요청");
        List<ReplyDTO> boardReplyList=replyService.boardReplyList(bno);
        log.info(boardReplyList);
        return  new ResponseEntity<>(boardReplyList, HttpStatus.OK);
    }

    @GetMapping("/board/userData")
    public ResponseEntity<MemberDTO> userData(Principal principal){
        log.info(principal);
        if (principal !=null) {
            MemberDTO memberDTO = userDetailsService.selectMember(principal.getName());
            return  new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }
            return  null;
    }

    @PostMapping("/board/replyRegister")
    public void replyRegister(ReplyDTO replyDTO){
        log.info(replyDTO);
        replyService.boardServiceRegister(replyDTO);
    }
}
