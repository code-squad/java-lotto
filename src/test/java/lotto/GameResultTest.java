package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GameResultTest {

    @Test
    public void 게임결과_생성_5등_한명() {
        GameResult gameResult = new GameResult();
        gameResult.saveGameResult(3, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(gameResult.winLottos.get(3)).hasSize(1).isInstanceOf(List.class);
    }

    @Test
    public void 게임결과_생성_3등_2명_1등_1명() {
        GameResult gameResult = new GameResult();

        gameResult.saveGameResult(5, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        gameResult.saveGameResult(5, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        gameResult.saveGameResult(6, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(gameResult.winLottos.get(5)).hasSize(2).isInstanceOf(List.class);
        assertThat(gameResult.winLottos.get(6)).hasSize(1).isInstanceOf(List.class);
    }
}
