package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class LottoDAOTest {
    private LottoDAO lottoDAO;

    @Before
    public void setUp() throws Exception {
        lottoDAO = new LottoDAO();
    }

    @Test
    public void 데이터베이스_연결하기() {
        Assert.assertNotNull(lottoDAO.getConnection());
    }

    @Test
    public void 로또번호_저장하기() {
        LottoBundle lottoBundle = LottoBundle.of();
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNum(1), new LottoNum(2), new LottoNum(3), new LottoNum(4), new LottoNum(5), new LottoNum(6)
        ));
        lottoBundle.addLotto(Arrays.asList(lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto));
        lottoDAO.saveBuyLottos(lottoBundle);
    }
}
