package board.study.mapper;

import board.study.memberDTO.MemberDTO;

public interface MemberMapper {
    MemberDTO selectMember (String userid); //아이디 로그인시 아이디로 조회
}
