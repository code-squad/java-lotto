package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoMachineTest {

    @Test
    public void 몇개살수있나() {
        assertEquals(1, LottoMachine.calcQuantity(1000));
    }

    @Test
    public void 사지못한다() {
        assertEquals(0, LottoMachine.calcQuantity(990));
    }

    @Test
    public void 총_얼마치를_구매했는가() {
        assertEquals(14000, LottoMachine.calcTotalPurchaseMoney(14));
    }
}