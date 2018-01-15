package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottosTest {
    private WinningLottos winningLottos;

    @Before
    public void init() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));

        winningLottos = new WinningLottos(
                LottoChecker.getWinnerLottos(lottos, new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7))
        );
    }

    @Test
    public void getProfitTest() {
        int profit = winningLottos.getProfit();
        assertThat(profit).isEqualTo(2030055000);
    }

    @Test
    public void getProfitPercentageTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));

        winningLottos = new WinningLottos(
                LottoChecker.getWinnerLottos(lottos, new WinningNumber(Arrays.asList(11, 12, 13, 14, 15, 16), 7))
        );
        int profitPercentage = winningLottos.getProfitPercentage(4000);
        assertThat(profitPercentage).isEqualTo(-100);
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
