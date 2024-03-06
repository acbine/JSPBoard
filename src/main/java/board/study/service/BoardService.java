package board.study.service;

import board.study.boardDTO.BoardDTO;
import board.study.boardDTO.PageDTO;

import java.util.List;

public interface BoardService {
    
    void boardServiceRegister(BoardDTO boardDTO);
    //등록
    
    void boardServiceDelete(Long bno);
    //삭제
    
    void boardServiceUpdate (BoardDTO boardDTO);
    //수정
    
    List<BoardDTO> boardServiceList(); //페이지 처리로인한 미사용ㅇ
    //읽기
    
    BoardDTO boardServiceViewDetail(Long bno);
    //상세보기

    List<BoardDTO> boardServiceSearchList(String searchWord , String type);
    //읽기

    List<BoardDTO> boardServicePage(PageDTO pageDTO);
}
