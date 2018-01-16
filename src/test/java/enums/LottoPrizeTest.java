package enums;

import domain.Money;
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
    }

    @Test
    public void totalCashPrizeTest() {
        assertThat(LottoPrize.FIRST.getTotalPrize(1)).isEqualTo(new Money(2000000000));
        assertThat(LottoPrize.SECOND.getTotalPrize(2)).isEqualTo(new Money(60000000));
        assertThat(LottoPrize.THIRD.getTotalPrize(3)).isEqualTo(new Money(4500000));
        assertThat(LottoPrize.FOURTH.getTotalPrize(4)).isEqualTo(new Money(200000));
    }
}
