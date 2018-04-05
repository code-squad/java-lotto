package domain;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
        String[] manualInputString = {"1, 2, 3, 4, 5, 6", "4, 5, 6, 7, 8, 9, 10"};
        List<LottoNoGroup> manualInput = LottoUtils.makeLottoNoGroup(manualInputString);
        User larry = User.whoHasMoneyOf(2000);
        larry.purchaseTicketsManual(manualInput);
        lottoDAO.insert(larry);
    }

    @Test
    public void findByUserId() throws Exception {
        User user = lottoDAO.findByUserId("userId");

        assertEquals(larry, user);
    }

}
