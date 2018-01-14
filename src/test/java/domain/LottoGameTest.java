package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @Before
    public void init() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 10, 15, 16)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 15, 16)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 15, 16)));

        lottoGame = new LottoGame(lottos);
    }

    @Test
    public void getNumOfLottosTest() {
        assertThat(lottoGame.getNumOfLottos()).isEqualTo(3);
    }

    @Test
    public void getLottoResultTest() {
        Map<Integer, Integer> winnerLottos = lottoGame.matchLottosWithWinnigNums(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winnerLottos.get(3)).isEqualTo(1);
        assertThat(winnerLottos.get(4)).isEqualTo(2);
        assertThat(winnerLottos.get(5)).isEqualTo(0);
        assertThat(winnerLottos.get(6)).isEqualTo(0);
    }
}
