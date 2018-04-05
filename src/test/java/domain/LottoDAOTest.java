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
    private User larry;


    @Before
    public void setup() {
        lottoDAO = new LottoDAO();
        larry = User.nameOf("larry");
    }

    @Test
    public void connection() {
        Connection con = lottoDAO.getConnection();
        assertNotNull(con);
    }

    @Test
    public void insertUser() throws SQLException {
        String[] manualInputString = {"1, 2, 3, 4, 5, 6", "4, 5, 6, 7, 8, 9, 10"};
        List<LottoNoGroup> manualInput = LottoUtils.makeLottoNoGroup(manualInputString);
        larry.hasMoneyOf(2000);
        larry.purchaseTicketsManual(manualInput);
        lottoDAO.insert(larry);
        // null check?
    }

    @Test
    public void insertWinningLotto() throws Exception {
        LotteryCommission koreaLC = new LotteryCommission();

        User user = lottoDAO.findResultByUserName("larry");
        assertEquals(larry, user);
    }

    @Test
    public void findResultByUserName() throws Exception {
        User user = lottoDAO.findResultByUserName("larry");
        assertEquals(larry, user);
    }

}
