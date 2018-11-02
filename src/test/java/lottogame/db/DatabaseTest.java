package lottogame.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DatabaseTest {
    Connection conn;

    @Before
    public void before() throws Exception {
        String url = "jdbc:mysql://207.148.110.44:3306/codesquad";
        String id = "nnn";
        String password = "nnn";

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, id, password);
    }

    @After
    public void after() throws Exception {
        conn.close();
    }

    @Test
    public void connectTest() throws Exception {
        assertThat(conn).isNotNull();
    }

    @Test
    public void insertTest() throws Exception {
        String query = "INSERT INTO lotto VALUE(?)";

        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setString(1, "1,2,3,4,5");

        pstm.execute();
    }

    @Test
    public void selectTest() throws Exception {
        String query = "SELECT * FROM lotto";

        PreparedStatement pstm = conn.prepareStatement(query);

        ResultSet res = pstm.executeQuery();
        res.next();
        System.out.println(res.getString("numbers"));
    }
}
