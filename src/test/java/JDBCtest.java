import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class JDBCtest {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testConn(){
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "c##BOARD",
                    "1234");

            log.info(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
