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
    }
}
