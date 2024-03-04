package board.study.service;

import board.study.boardDTO.BoardDTO;

import java.util.List;

public interface BoardService {
    
    void boardServiceRegister(BoardDTO boardDTO);
    //등록
    
    void boardServiceDelete(Long bno);
    //삭제
    
    void boardServiceUpdate (BoardDTO boardDTO);
    //수정
    
    List<BoardDTO> boardServiceList();
    //읽기
    
    BoardDTO boardServiceViewDetail(Long bno);
    //상세보기
}
