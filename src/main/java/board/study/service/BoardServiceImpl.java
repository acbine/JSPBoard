package board.study.service;

import board.study.boardDTO.BoardDTO;
import board.study.mapper.OracleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {


    OracleMapper oracleMapper;
    @Override
    public void boardServiceRegister(BoardDTO boardDTO) {
        oracleMapper.boardRegister(boardDTO);
    }

    @Override
    public void boardServiceDelete(Long bno) {
        oracleMapper.boardDelete(bno);
    }

    @Override
    public void boardServiceUpdate(BoardDTO boardDTO) {
        oracleMapper.boardUpdate(boardDTO);

    }

    @Override
    public List<BoardDTO> boardServiceList() {
        List<BoardDTO> returnList = oracleMapper.boardList();
        return returnList;
    }

    @Override
    public BoardDTO boardServiceViewDetail(Long bno) {
        return oracleMapper.boardViewDetail(bno);
    }
}
