package domain;

import org.junit.Before;
import org.junit.Test;
import utils.LottoMachine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LottoBundleTest {
    private LottoBundle lottoBundle;

    @Before
    public void setUp() throws Exception {
        lottoBundle = LottoBundle.of();
    }

    @Test
    public void 수동구매_로또가_null일때() {
        lottoBundle.addLotto(null);
        assertFalse(lottoBundle.isExistPurchaseHistory());
    }

    @Test
    public void 자동구매한_로또_추가하기() {
        lottoBundle.addLotto(LottoMachine.autoBuy(5, 3));
        assertTrue(lottoBundle.isExistPurchaseHistory());
    }
}