package lottogame.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @Before
    public void init(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)));
        lottoGame = new LottoGame(lottos);
    }

    @Test
    public void checkLotto() {
        Map<PrizeRank, Integer> resultMap = lottoGame.result(WinnningLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 13));
        assertThat(resultMap.get(PrizeRank.NO_MISS)).isEqualTo(0);
        assertThat(resultMap.get(PrizeRank.ONE_MISS)).isEqualTo(3);
        assertThat(resultMap.get(PrizeRank.TWO_MISS)).isEqualTo(3);
        assertThat(resultMap.get(PrizeRank.THREE_MISS)).isEqualTo(3);
    }

    @Test
    public void bonusPrize(){
        Map<PrizeRank, Integer> resultMap= lottoGame.result(WinnningLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),12));
        assertThat(resultMap.get(PrizeRank.NO_MISS)).isEqualTo(0);
        assertThat(resultMap.get(PrizeRank.ONE_MISS)).isEqualTo(0);
        assertThat(resultMap.get(PrizeRank.ONE_MISS_BONUS_HIT)).isEqualTo(3);
        assertThat(resultMap.get(PrizeRank.TWO_MISS)).isEqualTo(3);
        assertThat(resultMap.get(PrizeRank.THREE_MISS)).isEqualTo(3);
    }
}
