import board.study.boardDTO.BoardDTO;
import board.study.mapper.OracleMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OracleMapperTest {

    @Autowired
    OracleMapper oracleMapper;



    @Test
    public void registerTest(){
        for (int i=0; i<5; i++){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setTitle("등록테스트코드(제목)"+i);
            boardDTO.setContent("등록테스트코드(내용)"+i);
            boardDTO.setWriter("등록(작성자)"+i);
            oracleMapper.boardRegister(boardDTO);
        }
    }
    @Test
    public void deleteTest(){
        oracleMapper.boardDelete(27L);
    }
    @Test
    public void UpdateTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBno(22L);
        boardDTO.setTitle("수정테스트코드(제목)");
        boardDTO.setContent("수정테스트코드(내용)");
        boardDTO.setWriter("수정(작성자)");
        oracleMapper.boardUpdate(boardDTO);
    }

}
