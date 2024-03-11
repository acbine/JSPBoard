package board;


import board.study.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberTest {
    
    @Autowired
    PasswordEncoder passwordEncoder; //일반숫자를 암호화 하기위해
    
    @Autowired
    DataSource dataSource; //DB 연결

    @Autowired
    MemberMapper memberMapper;

    @Test
    public void insert(){

        String sql = "insert into board_member(userid, userpw, username) values (?,?,?)";
        // 1 , 2 , 3
        String sql2 = "insert into board_member_auth(userid,auth) values (?,?)";
        Connection con; //연결
        PreparedStatement pstmt; //쿼리 날리기 위해 사용ㅇ
        PreparedStatement pstmt2;
        try {
            con=dataSource.getConnection();
//            pstmt=con.prepareStatement(sql);
//            pstmt.setString(1,"2222"); //아이디
//            pstmt.setString(2,passwordEncoder.encode("1111")); //암호화된 비밀번호
//            pstmt.setString(3,"2번"); //사용자이름
//            pstmt.execute();


            pstmt2=con.prepareStatement(sql2);
            pstmt2.setString(1,"2222"); //아이디
            pstmt2.setString(2,"ROLE_MEMBER"); //암호화된 비밀번호
            pstmt2.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Test
    public void selectMember(){ //mapper로 변경
        log.info(memberMapper.selectMember("2222"));
        memberMapper.selectMember("2222").getAuthList().forEach(x->log.info(x));
    }
}
