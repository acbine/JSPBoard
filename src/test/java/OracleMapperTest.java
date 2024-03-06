import board.study.boardDTO.BoardDTO;
import board.study.boardDTO.PageDTO;
import board.study.mapper.OracleMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OracleMapperTest {

    @Autowired
    OracleMapper oracleMapper;



    @Test
    public void registerTest(){
        for (int i=0; i<=5; i++){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setTitle("등록테스트코드(제목)3");
            boardDTO.setContent("등록테스트코드(내용)3");
            boardDTO.setWriter("작성자3");
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

    @Test
    public void listTest(){
        oracleMapper.boardList();
    }

    @Test
    public void viewDetailTest(){
        oracleMapper.boardViewDetail(25L);
    }

    @Test
    public void searchTest(){
        oracleMapper.boardSearchList("한","writer");
    }

    @Test
    public void pageTest(){
        PageDTO pageDTO = new PageDTO(5,2); //  5페이지 * 2개씩 총갯수10개
        List<BoardDTO> list = oracleMapper.boardPage(pageDTO);
    }
}
