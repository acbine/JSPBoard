package board.study.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
public class SecurityController {
    @GetMapping("/board/loginPage")
    public void login(String error , String logout , Model model){
    
        log.info(error);
        log.info(logout);
        
        if (error != null){
            model.addAttribute("error","아이디나 비밀번호가 틀렸습니다"); //error: 로그인 시도 중에 오류가 발생했을 때, Spring Security가 자동으로 이 파라미터를 전달
        }

        if (logout != null){
            model.addAttribute("logout","로그아웃 했습니다"); //logout: 사용자가 로그아웃을 수행했을 때, Spring Security가 자동으로 이 파라미터를 전달
        }
    }

    @GetMapping("/board/accessDeny")
    public void accessDeny(){

    }
}
