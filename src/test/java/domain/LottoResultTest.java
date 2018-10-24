package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    public void obtainLottoResultTest() {
        assertThat(LottoResult.obtainLottoResult(3, 0)).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.obtainLottoResult(3, 1)).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.obtainLottoResult(4, 1)).isEqualTo(LottoResult.FOURTH);
        assertThat(LottoResult.obtainLottoResult(5, 0)).isEqualTo(LottoResult.THIRD);
        assertThat(LottoResult.obtainLottoResult(5, 1)).isEqualTo(LottoResult.SECOND);
    }

    @Test
    public void obtainLottoHitTest() {
        assertThat(LottoResult.obtainLottoHit(LottoResult.FIRST)).isEqualTo(6);
    }

    @Test
    public void obtainBonusHitTest() {
        assertThat(LottoResult.obtainBonusHit(LottoResult.SECOND)).isEqualTo(1);
    }
}
