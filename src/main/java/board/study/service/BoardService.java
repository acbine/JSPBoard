package board.study.service;

import board.study.boardDTO.BoardDTO;
import board.study.boardDTO.PageDTO;

import java.util.List;

public interface BoardService {
    
    void boardServiceRegister(BoardDTO boardDTO); //글 등록
    
    void boardServiceDelete(Long bno); //글삭제
    
    void boardServiceUpdate (BoardDTO boardDTO); //글 수정
    
    List<BoardDTO> boardServiceList(); //페이지 처리로인한 미사용ㅇ
    
    BoardDTO boardServiceViewDetail(Long bno); //상세보기

    List<BoardDTO> boardServiceSearchList(String searchWord , String type); //검색 페이징X

    List<BoardDTO> boardServicePage(PageDTO pageDTO); // 일반 페이징

    Long boardServiceBnoCount(); //글총갯수

    List<BoardDTO> boardServiceBoardSearchPage(String searchWord , String type , PageDTO pageDTO); //검색용 페이징

}
