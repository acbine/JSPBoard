package board.study.springsecurity;

import board.study.memberDTO.MemberDTO;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class AUser extends User { // Spring Security의 User 클래스는 사용자의 인증 및 권한을 나타냄

    long serialVersionUID =1L; //스프링 시큐리티에서 직렬화된 객체가 캐시되거나 세션에 저장될 때 이를 위해 사용
                                //자바의 직렬화 란? 자바 객체를 바이트스트림(데이터를 바이트(byte) 단위로 읽거나 쓰는 데 사용)으로 만들어서 파일, 데이터베이스, 메모리, 네트워크 송신이 가능

    MemberDTO memberDTO;
    public AUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AUser (MemberDTO memberDTO){
        super(memberDTO.getUserid(),memberDTO.getUserpw(),memberDTO.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
        //MemberDTO에서 사용자정보를 가져와 User클래스의 생성자를 호출하여 AUser객체를 초기화하고, 동시에 MemberDTO 객체를 AUser클래스의 멤버 변수에 할당합니다. 이를 통해 AUser 객체는 MemberDTO
        this.memberDTO = memberDTO;
    }
}
