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

    }

    @Override
    public void boardServiceDelete(BoardDTO boardDTO) {

    }

    @Override
    public void boardServiceUpdate(Long bno) {

    }

    @Override
    public List<BoardDTO> boardServiceList() {
        List<BoardDTO> returnList = oracleMapper.boardList();
        return returnList;
    }
}
