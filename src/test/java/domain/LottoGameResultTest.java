package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameResultTest {
    private LottoGameResult lottoGameResult;
    @Before
    public void init() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));

        lottoGameResult = new LottoGameResult(
                LottoChecker.getWinnerLottos(lottos, Arrays.asList(1, 2, 3, 4, 5, 6)),
                4000
        );
    }

    @Test
    public void getProfitTest() {
        int profit = lottoGameResult.getProfit();
        assertThat(profit).isEqualTo(2001555000);
    }

    @Test
    public void getProfitPercentageTest() {
        int profitPercentage = lottoGameResult.getProfitPercentage();
        assertThat(profitPercentage).isEqualTo(-50);
    }

    @Test
    public void getResultState() {
        assertThat(lottoGameResult.toString()).isEqualTo(
                        "3개 일치 (5000원)- 1개\n" +
                        "4개 일치 (50000원)- 1개\n" +
                        "5개 일치 (1500000원)- 1개\n" +
                        "6개 일치 (2000000000원)- 1개\n"
        );
    }
}
