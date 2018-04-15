package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class ResultViewTest {

    @Test
    public void 백분율_계산_10_퍼센트() {
        assertThat(ResultView.rateOfReturn(10, 100)).isEqualTo(10);
    }

    @Test
    public void 백분율_계산_1000_퍼센트() {
        assertThat(ResultView.rateOfReturn(1000, 100)).isEqualTo(1000);
    }

    @Test
    public void 로또_5등_당첨_당첨_총합_5000원() {
        GameResult result = new GameResult();
        result.accumulateWinLotto(Rank.FIFTH);

        assertThat(ResultView.getTotal(result)).isEqualTo(5000);
    }

    @Test
    public void 로또_1등_5등_당첨_당첨_총합_2000005000원() {
        GameResult result = new GameResult();
        result.accumulateWinLotto(Rank.FIRST);
        result.accumulateWinLotto(Rank.FIFTH);

        assertThat(ResultView.getTotal(result)).isEqualTo(2_000_005_000);
    }

    @Test
    public void 로또_5장_구매_로또_1등_5등_당첨_총수익률_40000100_퍼센트() {
        GameResult result = new GameResult();
        result.accumulateWinLotto(Rank.FIRST);
        result.accumulateWinLotto(Rank.FIFTH);

        assertThat(ResultView.rateOfReturn(ResultView.getTotal(result), 5000)).isEqualTo("40000100");
    }
}
