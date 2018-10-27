package lotto.domain;

import lotto.dto.ResultDto;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    public void countMatchLotto() {
        GameResult result = new GameResult();
        result.countMatchLotto(3,false);
        ResultDto dto = result.createResultDto(1);
        assertThat(dto.getResults().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void getMap() {
        GameResult result = new GameResult();
        ResultDto dto = result.createResultDto(1);
        Map map = dto.getResults();
        assertThat(map.get(Rank.FIRST)).isEqualTo(0);
    }
}
