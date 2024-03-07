package board.study.mapper;

import board.study.boardDTO.BoardDTO;
import board.study.boardDTO.PageDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OracleMapper {
    void boardRegister(BoardDTO boardDTO);
    //글등록(등록할 글 내용및 제목 작성자)

    void boardDelete(Long bno);
    //글삭제 (삭제할글번호)
    
    void boardUpdate(BoardDTO boardDTO);
    //글수정 (수정할 글번호및 수정될 내용) => 글수정(수정될내용)
    //boardDTO안에 bno라는 게 존재 한다면 boardDTO안의 bno를 가져오고 그렇지 안다면 Long의 bno를 가져온다
    //쿼리자체는 잘실행이 되는데 동시에 하니 파라미터를 찾을수없다는 오류가 남 => 수정될 내용안에 bno를 집어넣기로 결정

    List<BoardDTO> boardList();
    //DB에있는 모든 리스트 불러오기
    
    BoardDTO boardViewDetail(Long bno);
    //정보 하나 불러오기

    List<BoardDTO> boardSearchList(@Param("searchWord") String searchWord,  @Param("type")String type);
    //검색된 정보 불러오기

    List<BoardDTO> boardPage(PageDTO pageDTO);

    Long boardBnoCount();

    List<BoardDTO> boardSearchPage(@Param("searchWord") String searchWord,  @Param("type")String type, @Param("pageDTO")PageDTO pageDTO);
}
