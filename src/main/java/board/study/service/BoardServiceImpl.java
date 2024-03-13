package board.study.service;

import board.study.boardDTO.BoardDTO;
import board.study.boardDTO.PageDTO;
import board.study.mapper.OracleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
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

    @Override
    public List<BoardDTO> boardServiceSearchList(String searchWord , String type) {
        return oracleMapper.boardSearchList(searchWord,type);
    }

    @Override
    public List<BoardDTO> boardServicePage(PageDTO pageDTO) {
        return oracleMapper.boardPage(pageDTO);
    }

    @Override
    public Long boardServiceBnoCount() {
        return oracleMapper.boardBnoCount();
    }

    @Override
    public List<BoardDTO> boardServiceBoardSearchPage(String searchWord, String type , PageDTO pageDTO) {
        return oracleMapper.boardSearchPage(searchWord,type,pageDTO);
    }

    @Override
    public Long boardServiceboardSearchBnoCount(String searchWord, String type) {
        return oracleMapper.boardSearchBnoCount(searchWord, type);
    }


}
