package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.LottoPrize.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    private Lottos lottos;
    private WinningNumber winningNumber;

    @Before
    public void init() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 10, 15, 16)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 15, 16)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 15, 16)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        this.lottos = new Lottos(lottos);
        winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNo(7));
    }

    @Test
    public void getNumOfLottosTest() {
        assertThat(lottos.getNumOfLottos()).isEqualTo(5);
    }

    @Test
    public void getWinningLottoTest() {
        WinningLottos winningLottos = lottos.getWinningLottos(winningNumber);

        assertThat(winningLottos.getNumOfWinnerLottoByPrize(FIFTH)).isEqualTo(1);
        assertThat(winningLottos.getNumOfWinnerLottoByPrize(FOURTH)).isEqualTo(2);
        assertThat(winningLottos.getNumOfWinnerLottoByPrize(THIRD)).isEqualTo(0);
        assertThat(winningLottos.getNumOfWinnerLottoByPrize(SECOND)).isEqualTo(1);
        assertThat(winningLottos.getNumOfWinnerLottoByPrize(FIRST)).isEqualTo(1);
    }

    @Test
    public void joinTest() {
        assertThat(lottos.join(lottos).getNumOfLottos()).isEqualTo(10);
    }
}
