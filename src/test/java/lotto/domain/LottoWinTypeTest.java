package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTypeTest {
    @Test
    public void isMatchCount테스트() {
        assertThat(LottoWinType.FOUR_MATCH.isMatchCount(4)).isEqualTo(true);
    }

    @Test
    public void valueOf테스트() {
        assertThat(LottoWinType.valueOf(3)).isEqualTo(LottoWinType.THREE_MATCH);
        assertThat(LottoWinType.valueOf(4)).isEqualTo(LottoWinType.FOUR_MATCH);
        assertThat(LottoWinType.valueOf(5)).isEqualTo(LottoWinType.FIVE_MATCH);
        assertThat(LottoWinType.valueOf(6)).isEqualTo(LottoWinType.SIX_MATCH);
    }

    @Test
    public void contains테스트() {
        assertThat(LottoWinType.contains(3)).isEqualTo(true);
        assertThat(LottoWinType.contains(7)).isEqualTo(false);
    }
}
