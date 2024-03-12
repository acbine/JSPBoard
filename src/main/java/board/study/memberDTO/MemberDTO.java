package board.study.memberDTO;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
public class MemberDTO {

    private String userid;   //오라클 테이블에 있던것
    private String userpw;
    private String userName;
    private boolean enabled;

    private Date regDate;
    private Date updateDate;

    private List<MemberAUTHDTO> authList; //이 권한이 한개가 아닌 여러개 일수도 있으므로 리스트 처리 ex)member admin


}
