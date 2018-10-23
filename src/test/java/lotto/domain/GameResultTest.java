package lotto.domain;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    public void countMatchLotto() {
        GameResult result = new GameResult();
        GameResult.countMatchLotto(3,false);
        assertThat(result.getResults().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void getMap() {
        GameResult result = new GameResult();
        Map map = result.getResults();
        assertThat(map.get(Rank.FIRST)).isEqualTo(0);
    }
}
