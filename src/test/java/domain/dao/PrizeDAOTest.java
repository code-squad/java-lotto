package domain.dao;

import domain.result.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PrizeDAOTest {
    private PrizeDAO prizeDAO;

    @Before
    public void setUp() throws Exception {
        prizeDAO = PrizeDAO.of();
    }

    @Test
    public void 데이터베이스_연결() {
        assertNotNull(prizeDAO.getConnection());
    }

    @Test
    public void 랭크_데이터_저장하기() {
        prizeDAO.savePrizeInfo(Rank.FIRST.getMatchPoint(), 1);
    }
}
