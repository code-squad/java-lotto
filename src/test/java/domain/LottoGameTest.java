package domain;

import enums.LottoPrize;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static enums.LottoPrize.*;
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
        Map<LottoPrize, Integer> winnerLottos = lottoGame.matchLottosWithWinnigNums(
                new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
        assertThat(winnerLottos.get(FIFTH)).isEqualTo(1);
        assertThat(winnerLottos.get(FOURTH)).isEqualTo(2);
        assertThat(winnerLottos.get(THIRD)).isEqualTo(0);
        assertThat(winnerLottos.get(FIRST)).isEqualTo(0);
    }
}
