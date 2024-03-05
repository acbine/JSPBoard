package board.study.boardDTO;

import lombok.Data;

@Data
public class PageDTO {

    private int pageNum=1;//페이지 번호 기본 1
    private int amount=5; //한페이지에 보여줄 갯수

    public PageDTO() { //기본생성자
        this(1,10);
    }

    public PageDTO(int pageNum, int amount) {
        super();
        this.pageNum = pageNum;
        this.amount = amount;
    }

}
