package board.study.mapper;

import board.study.memberDTO.MemberDTO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    MemberDTO selectMember (String userid); //아이디 로그인시 아이디로 조회

    void memberRegister(MemberDTO memberDTO); //회원가입 바탕으로 저장

    void memberAuthRegister(@Param("userid") String userid ,@Param("auth") String auth); //권한부여
}
