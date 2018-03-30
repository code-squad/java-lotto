package utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyUtilsTest {

    @Test
    public void 몇개살수있는_금액인가() {
        assertEquals(1, MoneyUtils.calcBuyAmount(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구매할수없는_금액() {
        MoneyUtils.calcBuyAmount(999);
    }

    @Test
    public void 수익률_계산() {
        assertEquals(20000000, MoneyUtils.calcProfit(2000000000, 10));
    }
}
