import board.study.mapper.OracleMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OracleMapperTest {

    @Autowired
    OracleMapper oracleMapper;

    @Test
    public void OTest(){
        oracleMapper.sysdateXml();
        System.out.println("안녕");
    }

    @Test
    public void O2Test(){
        oracleMapper.sysdate();
        System.out.println("안녕");
    }

}
