package enums;

import org.junit.Test;

import static enums.LottoPrize.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPrizeTest {
    @Test
    public void lottoPrizeTest() {
        assertThat(LottoPrize.valueOf(6, false)).isEqualTo(FIRST);
        assertThat(LottoPrize.valueOf(5, true)).isEqualTo(SECOND);
        assertThat(LottoPrize.valueOf(5, false)).isEqualTo(THIRD);
        assertThat(LottoPrize.valueOf(4, false)).isEqualTo(FOURTH);
        assertThat(LottoPrize.valueOf(3, false)).isEqualTo(FIFTH);
        assertThat(LottoPrize.valueOf(2, false)).isEqualTo(LOSING_LOTTO);
        assertThat(LottoPrize.valueOf(1, false)).isEqualTo(LOSING_LOTTO);
        assertThat(LottoPrize.valueOf(0, false)).isEqualTo(LOSING_LOTTO);
    }

    @Test
    public void totalCashPrizeTest() {
        assertThat(LottoPrize.FIRST.getTotalPrize(1)).isEqualTo(2000000000);
        assertThat(LottoPrize.SECOND.getTotalPrize(2)).isEqualTo(60000000);
        assertThat(LottoPrize.THIRD.getTotalPrize(3)).isEqualTo(4500000);
        assertThat(LottoPrize.FOURTH.getTotalPrize(4)).isEqualTo(200000);
        assertThat(LottoPrize.LOSING_LOTTO.getTotalPrize(4)).isEqualTo(0);
    }
}
