package board.study.boardDTO;

import lombok.Data;

@Data
public class PagebarDTO {
    private int startPage; //시작페이지 -->무조건 1
    private int endPage; //끝페이지
    private int totalEndPage; //이거클릭시 맨 뒤페이지로 가는 것
    private int totalStartPage; ////이거클릭시 맨 앞페이지로 가는 것
    private PageDTO pageDTO; // 페이지 기본 번호 , 한페이지의 글개수
    private long  total;// 총글갯수
    private boolean prev;// 이전페이지 10개씩 건너뛰기
    private boolean next; //다음페이지 10개씩 건너뛰기

    public PagebarDTO (PageDTO pageDTO, long total){ //total=>모든글갯수
        this.pageDTO=pageDTO;
        this.total=total;

        //페이지바의 끝페이지 = (올림(현재페이지/10))*10
        //현제페이지가 3일경우 가정                 (올림(3/10)) *10 =>    1.0*10     끝페이지는 10페이지
        //현제페이지가 21일경우 가정                     (올림(21/10)*10 => 3.0*10    끝페이지는 30페이지
        endPage =  (int)((Math.ceil(pageDTO.getPageNum()/10.0))*10);

        startPage = endPage-9; // 30-9  시작페이지 21                   21~30까지

        totalStartPage=1; // 맨처음페이지 무조건 1

        //진짜마지막페이지		//소숫점 올림 (전체글/한페이지당 개수)
        //                 올림(총글61)/10 => 7페이지
        totalEndPage=(int)Math.ceil((total*1.0)/pageDTO.getAmount());


        //페이지바의 끝페이가 진짜 마지막페이지보다 크면 진짜로 변경
        if(endPage>totalEndPage) {
            endPage=totalEndPage;
        }

        //시작페이지가 1이 아닐때 prev가 true;
        prev =(startPage !=1);

        //endPage 끝페이잘면 next가 true
        next = (endPage != totalEndPage);


    }
}
