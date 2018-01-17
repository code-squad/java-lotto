package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.LottoPrize.FIRST;
import static enums.LottoPrize.THIRD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottosTest {
    private WinningLottos winningLottos;

    @Before
    public void init() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        winningLottos = new Lottos(lottos).getWinningLottos(
                    new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new LottoNo(7)
                    )
        );
    }

    @Test
    public void addLottoTest() {
        winningLottos.addLotto(THIRD);
        assertThat(winningLottos.getNumOfWinnerLottoByPrize(THIRD)).isEqualTo(1);
    }

    @Test
    public void getNumOfWinnerLottoByPrizeTest() {
        assertThat(winningLottos.getNumOfWinnerLottoByPrize(FIRST)).isEqualTo(1);
    }

    @Test
    public void getTotalPrizeTest() {
        int profit = winningLottos.getTotalPrize();
        assertThat(profit).isEqualTo(2030055000);
    }

    @Test
    public void getResultState() {
        assertThat(winningLottos.toString()).isEqualTo(
            "3개 일치 (5000원)- 1개\n" +
            "4개 일치 (50000원)- 1개\n" +
            "5개 일치 (1500000원)- 0개\n" +
            "5개 일치, 보너스 볼 일치 (30000000원)- 1개\n" +
            "6개 일치 (2000000000원)- 1개\n"
        );
    }
}
