package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoPrizeTest {
    @Test
    public void letMeKnowPrize() throws Exception {
        assertEquals(LottoPrize.NONE, LottoPrize.letMeKnowPrize(0, true));
        assertEquals(LottoPrize.NONE, LottoPrize.letMeKnowPrize(0, false));
        assertEquals(LottoPrize.NONE, LottoPrize.letMeKnowPrize(1, true));
        assertEquals(LottoPrize.NONE, LottoPrize.letMeKnowPrize(1, false));
        assertEquals(LottoPrize.NONE, LottoPrize.letMeKnowPrize(2, true));
        assertEquals(LottoPrize.NONE, LottoPrize.letMeKnowPrize(2, false));
        assertEquals(LottoPrize.THREE, LottoPrize.letMeKnowPrize(3, true));
        assertEquals(LottoPrize.THREE, LottoPrize.letMeKnowPrize(3, false));
        assertEquals(LottoPrize.FOUR, LottoPrize.letMeKnowPrize(4, true));
        assertEquals(LottoPrize.FOUR, LottoPrize.letMeKnowPrize(4, false));
        assertEquals(LottoPrize.FIVE, LottoPrize.letMeKnowPrize(5, false));
        assertEquals(LottoPrize.FIVE_BONUS, LottoPrize.letMeKnowPrize(5, true));
        assertEquals(LottoPrize.SIX, LottoPrize.letMeKnowPrize(6, true));
        assertEquals(LottoPrize.SIX, LottoPrize.letMeKnowPrize(6, false));

    }

}