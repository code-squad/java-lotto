package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTypeTest {
    @Test
    public void getPrizeByMatchCount테스트() {
        assertThat(LottoWinType.getPrizeByMatchCount(3)).isEqualTo(5000);
        assertThat(LottoWinType.getPrizeByMatchCount(4)).isEqualTo(50000);
        assertThat(LottoWinType.getPrizeByMatchCount(5)).isEqualTo(1500000);
        assertThat(LottoWinType.getPrizeByMatchCount(6)).isEqualTo(2000000000);
    }
}
