package board.study.service;

import board.study.boardDTO.BoardDTO;

import java.util.List;

public interface BoardService {
    //등록
    void boardServiceRegister(BoardDTO boardDTO);
    //삭제
    void boardServiceDelete(BoardDTO boardDTO);
    //수정
    void boardServiceUpdate (Long bno);
    //일기
    List<BoardDTO> boardServiceList();
}
