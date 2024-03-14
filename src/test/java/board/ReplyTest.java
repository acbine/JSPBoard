package board;

import board.study.boardDTO.ReplyDTO;
import board.study.mapper.ReplyMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class ReplyTest {

    @Autowired
    ReplyMapper replyMapper;

    @Test
    public void replyRegisterTest(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setBno(142L);
        replyDTO.setReplywriter("4번");
        replyDTO.setReplycontent("4안녕");
        replyMapper.boardReplyRegister(replyDTO);
    }

    @Test
    public void replyUpdateTest(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setRno(3L);
        replyDTO.setBno(142L);
        replyDTO.setReplywriter("3번");
        replyDTO.setReplycontent("3안녕 수정");
        replyMapper.boardReplyUpdate(replyDTO);
    }
    @Test
    public void replyDeleteTest(){
        replyMapper.boardReplyDelete(2L);
    }
    @Test
    public void replyListTest(){
        log.info(replyMapper.boardReplyList(142L));
    }
}
