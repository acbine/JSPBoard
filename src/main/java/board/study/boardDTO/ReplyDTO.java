package board.study.boardDTO;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long rno;
	private Long bno;
	private String replywriter;
	private String replycontent;
	private Date replyDate;
	private Date updateDate;

}
