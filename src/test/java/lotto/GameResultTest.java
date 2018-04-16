package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class GameResultTest {
    private GameResult result;

    @Before
    public void setUp() {
        result = new GameResult();
    }

    @Test
    public void 게임결과_생성_5등_한명() {
        result.accumulateWinLotto(Rank.FIFTH);
        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 게임결과_생성_3등_2명_1등_1명() {
        result.accumulateWinLotto(Rank.THIRD);
        result.accumulateWinLotto(Rank.THIRD);
        result.accumulateWinLotto(Rank.FIRST);

        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(2);
        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    public void 백분율_계산_10_퍼센트() {
        result.accumulateWinLotto(Rank.FIFTH);
        assertThat(result.rateOfReturn(50_000)).isEqualTo("10");
    }

    @Test
    public void 백분율_계산_1000_퍼센트() {
        result.accumulateWinLotto(Rank.FOURTH);
        assertThat(result.rateOfReturn(5_000)).isEqualTo("1000");
    }

    @Test
    public void 로또_5등_당첨_당첨_총합_5000원() {
        result.accumulateWinLotto(Rank.FIFTH);
        assertThat(result.totalWinMoney()).isEqualTo(5000);
    }

    @Test
    public void 로또_1등_5등_당첨_당첨_총합_2000005000원() {
        GameResult result = new GameResult();
        result.accumulateWinLotto(Rank.FIRST);
        result.accumulateWinLotto(Rank.FIFTH);

        assertThat(result.totalWinMoney()).isEqualTo(2_000_005_000);
    }

    @Test
    public void 로또_5장_구매_로또_1등_5등_당첨_총수익률_40000100_퍼센트() {
        GameResult result = new GameResult();
        result.accumulateWinLotto(Rank.FIRST);
        result.accumulateWinLotto(Rank.FIFTH);

        assertThat(result.rateOfReturn(5000)).isEqualTo("40000100");
    }
}
