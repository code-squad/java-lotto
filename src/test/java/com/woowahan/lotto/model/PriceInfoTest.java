package com.woowahan.lotto.model;

import com.woowahan.lotto.model.PriceInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceInfoTest {
    @Test
    public void winningCondition으로_PriceInfo_가져오기_5개맞고_보너스맞음() {
        PriceInfo priceInfo = PriceInfo.getValueByWinningCondition(5, true);

        assertEquals(PriceInfo.FIVE_BONUS, priceInfo);
    }

    @Test
    public void winningCondition으로_PriceInfo_가져오기_3개맞고_보너스맞음() {
        PriceInfo priceInfo = PriceInfo.getValueByWinningCondition(3, true);

        assertEquals(PriceInfo.THREE, priceInfo);
    }

    @Test
    public void checkValue_method_테스트() {
        boolean result = PriceInfo.checkValue(PriceInfo.FIVE, 5, false);
        boolean result2 = PriceInfo.checkValue(PriceInfo.FIVE_BONUS, 5, true);

        assertEquals(true, result2);
        assertEquals(true, result);
    }
}