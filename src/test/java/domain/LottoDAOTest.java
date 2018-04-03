package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class LottoDAOTest {
    private LottoDAO lottoDAO;
    private LottoBundle lottoBundle;
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lottoDAO = new LottoDAO();
        lottoBundle = new LottoBundle();
        lotto = new Lotto(Arrays.asList(
                new LottoNum(1), new LottoNum(2), new LottoNum(3), new LottoNum(4), new LottoNum(5), new LottoNum(6)
        ));
        lottoBundle.addLotto(Arrays.asList(lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto, lotto));
    }

    @Test
    public void 데이터베이스_연결하기() {
        Assert.assertNotNull(lottoDAO.getConnection());
    }

    @Test
    public void 로또번호_저장하기() {
        lottoDAO.saveBuyLottos(lottoBundle);
    }

    @Test
    public void 로또번호_가져오기() {
        LottoBundle savedLottoBundle = lottoDAO.getBuyLottos();
        System.out.println(savedLottoBundle);
    }

    @Test
    public void 로또번호_삭제하기() {
        lottoDAO.deleteLottosRecord();
    }
}
