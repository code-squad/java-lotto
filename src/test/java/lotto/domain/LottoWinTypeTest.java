package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTypeTest {
    @Test
    public void isMatchCount테스트() {
        assertThat(LottoWinType.FOURTH.isMatchCount(4)).isEqualTo(true);
    }

    @Test
    public void valueOf테스트() {
        assertThat(LottoWinType.valueOf(3)).isEqualTo(LottoWinType.FIFTH);
        assertThat(LottoWinType.valueOf(4)).isEqualTo(LottoWinType.FOURTH);
        assertThat(LottoWinType.valueOf(5)).isEqualTo(LottoWinType.THIRD);
        assertThat(LottoWinType.valueOf(6)).isEqualTo(LottoWinType.FIRST);
        assertThat(LottoWinType.valueOf(5, true)).isEqualTo(LottoWinType.SECOND);
    }
}
