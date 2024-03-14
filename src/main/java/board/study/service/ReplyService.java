package board.study.service;

import board.study.boardDTO.ReplyDTO;

import java.util.List;



public interface ReplyService {

	void boardServiceRegister(ReplyDTO ReplyDTO);

	List<ReplyDTO> boardReplyList(Long bno);

	void boardReplyUpdate(ReplyDTO vo);

	void boardReplyDelete(Long rno);


	 
	
}	
