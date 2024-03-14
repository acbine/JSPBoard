package board.study.mapper;

import board.study.boardDTO.ReplyDTO;

import java.util.List;



public interface ReplyMapper {
	void boardReplyRegister(ReplyDTO ReplyDTO); //등록

	List<ReplyDTO> boardReplyList(Long bno); //불러오기

	void boardReplyUpdate(ReplyDTO vo); //수정

	void boardReplyDelete(Long rno); //삭제

}
