package board.study.controller;

import board.study.memberDTO.MemberDTO;
import board.study.service.UserDetailsServiceImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Log4j
public class SecurityController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @GetMapping("/board/loginPage")
    public void login(String error , String logout , Model model){
    
        log.info(error);
        log.info(logout);
        model.addAttribute("successJudgemet",false);

        
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

    @GetMapping("/board/memberRegister")
    public String memberRegister(Principal principal){
        log.info("회원가입 페이지");
        if (principal != null){
            return "redirect: /board/list";
        }else {
            return "/board/memberRegister";
        }
    }

    @PostMapping("/board/membership")
    public String membership(MemberDTO memberDTO ,Model model){
        log.info("회원가입 신호옴");
        log.info(memberDTO);
        try{
            userDetailsService.registerMember(memberDTO);
            model.addAttribute("successJudgemet",true);
            model.addAttribute("success","회원가입이 무사히 되었습니다");
            log.info("회원가입 성공");
            return "/board/loginPage";
        }catch (Exception e){
            model.addAttribute("successJudgemet",false);
            model.addAttribute("error","아이디가 중복입니다");
            log.info("회원가입 실패");
            return "/board/memberRegister";
        }


    }
}
