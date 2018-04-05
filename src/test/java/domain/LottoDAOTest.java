package domain;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import static domain.LottoUtils.listToLottoNoGroup;
import static domain.LottoUtils.makeLottoNoGroup;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class LottoDAOTest {

    private LottoDAO lottoDAO;
    private User user;
    private String round;

    @Before
    public void setup() {
        lottoDAO = new LottoDAO();
        user = User.nameOf("testUser");
        round = "1";
    }

    @Test
    public void connection() {
        Connection con = lottoDAO.getConnection();
        assertNotNull(con);
    }

    @Test
    public void crud_Users_table() throws SQLException {
        user.hasMoneyOf(1000);
        lottoDAO.insertUserInfo(user, round, "1000");
        User dbUser = lottoDAO.findLottoNumbersByUserNameAndRoundFromUsers("testUser", String.valueOf(round));
        assertThat(user, is(dbUser));
        lottoDAO.removeUserInfo(user, round);
    }

    @Test
    public void crud_Lottos_table() throws SQLException {
        user.hasMoneyOf(1000);
        user.purchaseTicketsManual(makeLottoNoGroup(new String[]{"1, 2, 3, 4, 5, 6"}));
        lottoDAO.insertLottosInfo(user, round, "1000");
        User dbUser = lottoDAO.findLottoNumbersByUserNameAndRoundFromLottos("testUser", String.valueOf(round));
        assertThat(user, is(dbUser));
        lottoDAO.removeLottosInfo(user, round);
    }

    @Test
    public void crud_WinningLottos_table() throws SQLException {
        LotteryCommission lotteryCommission = new LotteryCommission(Integer.parseInt(round));
        lotteryCommission.selectWinningNumbers(listToLottoNoGroup(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNo.of(10));
        lottoDAO.insertWinningLotto(round, "1, 2, 3, 4, 5, 6", "10");
        LotteryCommission dbLotteryCommission = lottoDAO.findWinningNumberByRound(round);
        assertThat(lotteryCommission, is(dbLotteryCommission));
        lottoDAO.removeWinningLotto(round);
    }


}
