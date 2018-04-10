import dao.LottoDAO;
import lotto.Lotto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LottoDaoTest {
    private LottoDAO lottoDao;
    private Lotto testLotto;
    private List<Lotto> lottos;

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
        assertNotNull(lottoDao.readLottos());
    }

    @Test
    public void 로또불러오기() throws SQLException {
        lottoDao.readLottos();
        assertNotNull(lottoDao.readLottos());
    }
}
