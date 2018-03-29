package utils;

import domain.Lotto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LottoMachineTest {

    @Test
    public void 자동구매() {
        List<Lotto> lotto = LottoMachine.autoBuy(1, 0);
        assertEquals(1, lotto.size());
    }

    @Test
    public void 자동수량_0개() {
        assertNull(LottoMachine.autoBuy(3, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동수량보다_자동수량_오버입력() {
        LottoMachine.autoBuy(3, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동수량_마이너스_입력() {
        LottoMachine.manualBuy(-1);
    }

    @Test
    public void 수동수량_0개() {
        assertNull(LottoMachine.manualBuy(0));
    }


}