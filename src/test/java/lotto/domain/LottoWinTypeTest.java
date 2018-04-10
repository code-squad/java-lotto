package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTypeTest {
    @Test
    public void getPrizeByMatchCount테스트() {
        assertThat(LottoWinType.valueOf(3).getPrize()).isEqualTo(5000);
        assertThat(LottoWinType.valueOf(4).getPrize()).isEqualTo(50000);
        assertThat(LottoWinType.valueOf(5).getPrize()).isEqualTo(1500000);
        assertThat(LottoWinType.valueOf(6).getPrize()).isEqualTo(2000000000);
    }
}
