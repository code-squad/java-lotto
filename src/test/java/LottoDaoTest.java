import lotto.Lotto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

public class LottoDaoTest {
    private LottoDAO lottoDao;
    private Lotto testLotto;

    @Before
    public void setUp() throws Exception {
        lottoDao = new LottoDAO();
    }

    @Test
    public void DB연결테스트() {
        Connection conn = lottoDao.getConnection();
        assertNotNull(conn);
    }

    @Test
    public void 로또넣기() throws SQLException {
        Lotto testLotto = new Lotto("1,2,3,4,5,6");
        lottoDao.insert(testLotto);
    }

    @Test
    public void 로또id로불러오기() {
        Lotto testLotto2 = new Lotto("11,22,33,44,55,66");
        lottoDao.findById()
    }
}
