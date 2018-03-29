package utils;

import domain.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoMachineTest {
    private Lotto sample;

    @Before
    public void setUp() throws Exception {
        sample = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 수동구매() {
        Lotto lotto = LottoMachine.manualBuy(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(6, lotto.match(sample));
    }

    @Test
    public void 자동구매() {
        List<Lotto> lotto = LottoMachine.autoBuy(1);
        assertEquals(1, lotto.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자동구매_유효하지않은_수량_마니너스() {
        LottoMachine.autoBuy(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자동구매_유효하지않은_수량_0개() {
        LottoMachine.autoBuy(0);
    }

    @Test
    public void 살수있는_수량() {
        assertTrue(LottoMachine.canBuy(1));
    }

    @Test
    public void 살수없는_수량() {
        assertFalse(LottoMachine.canBuy(0));
    }
}