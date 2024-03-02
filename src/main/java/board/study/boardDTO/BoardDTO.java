package board.study.boardDTO;

import lombok.Data;

@Data
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
}
