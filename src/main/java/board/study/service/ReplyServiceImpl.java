package board.study.service;

import java.util.List;

import board.study.boardDTO.ReplyDTO;
import board.study.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyMapper replyMapper;

	@Override
	public void boardServiceRegister(ReplyDTO ReplyDTO) {
		replyMapper.boardReplyRegister(ReplyDTO);
	}

	@Override
	public List<ReplyDTO> boardReplyList(Long bno) {
		return replyMapper.boardReplyList(bno);
	}

	@Override
	public void boardReplyUpdate(ReplyDTO ReplyDTO) {
		replyMapper.boardReplyUpdate(ReplyDTO);
	}

	@Override
	public void boardReplyDelete(Long rno) {
		replyMapper.boardReplyDelete(rno);
	}
}
