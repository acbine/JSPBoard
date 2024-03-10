package board.study.springsecurity;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class LoginSuccess implements AuthenticationSuccessHandler { //스프링 시큐리티를 사용하면 AuthenticationSuccessHandler 사용가능
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // implements AuthenticationSuccessHandler=> 핸들러는 인증 성공 시에 실행할 작업을 정의하는 데 사용
        // HttpServletRequest httpServletRequest 요청객체  요청에 대한 정보를 얻거나 수정
        // HttpServletResponse httpServletResponse: 응답 객체 이 객체를 사용하여 응답을 조작데이터를 전송
        //Authentication authentication: 인증 객체 인증된 사용자의 세부 정보나 권한을 확인

        List<String> roleNames = new ArrayList<>(); //권한이 여러개일겨우를 대비해 리스트로 만듬

        authentication.getAuthorities().forEach(authority -> { //아까 로그인시 받은 정보를 리스트에  넣어놈
            roleNames.add(authority.getAuthority());
            
        });

        if (roleNames.contains("ROLE_ADMIN")) {
            Object principal = authentication.getPrincipal();
            String username = ((UserDetails) principal).getUsername();
            System.out.println(username);

            httpServletResponse.sendRedirect("/board/list");
            return;
        }

        if (roleNames.contains("ROLE_MEMBER")) {

            httpServletResponse.sendRedirect("/board/list");
            return;
        }

        httpServletResponse.sendRedirect("/");


    }
}
