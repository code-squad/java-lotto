package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class GameResultTest {

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 게임결과_생성_5등_한명() {
        GameResult gameResult = new GameResult();
        gameResult.accumulateWinLottoCount(3);
        assertThat(gameResult.getWinningCount(3)).isEqualTo(1);
    }

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 게임결과_생성_3등_2명_1등_1명() {
        GameResult gameResult = new GameResult();

        gameResult.accumulateWinLottoCount(3);
        gameResult.accumulateWinLottoCount(3);
        gameResult.accumulateWinLottoCount(6);

        assertThat(gameResult.getWinningCount(3)).isEqualTo(2);
        assertThat(gameResult.getWinningCount(6)).isEqualTo(1);
    }
}
