package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class GameResultTest {

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 게임결과_생성_5등_한명() {
        GameResult result = new GameResult();
        result.accumulateWinLotto(Rank.FIFTH);
        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 게임결과_생성_3등_2명_1등_1명() {
        GameResult result = new GameResult();

        result.accumulateWinLotto(Rank.THIRD);
        result.accumulateWinLotto(Rank.THIRD);
        result.accumulateWinLotto(Rank.FIRST);

        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(2);
        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
    }
}
