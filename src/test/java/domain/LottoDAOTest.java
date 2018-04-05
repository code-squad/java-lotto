package domain;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LottoDAOTest {

    private LottoDAO lottoDAO;

    @Before
    public void setup() {
        lottoDAO = new LottoDAO();
    }

    @Test
    public void connection() {
        Connection con = lottoDAO.getConnection();
        assertNotNull(con);
    }

    @Test
    public void insert() throws SQLException {
        User larry = User.whoHasMoneyOf(3000);
        larry.purchaseTicketsManual();
        lottoDao.insert(larry);
    }

    @Test
    public void findByUserId() throws Exception {
        User user = lottoDao.findByUserId("userId");
        User larry = new User("larryjung", "db1004", "larry", "sscc112@naver.com");
        assertEquals(larry, user);
    }

}
