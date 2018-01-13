package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameResultTest {
    @Test
    public void getResultSetTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoGameResult lottoGameResult = new LottoGameResult(lottos, 4000);

        Map<Integer, List<Lotto>> lottoResult = lottoGameResult.getResult(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoResult.get(3).get(0)).isEqualTo(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));
        assertThat(lottoResult.get(4).get(0)).isEqualTo(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        assertThat(lottoResult.get(5).get(0)).isEqualTo(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(lottoResult.get(6).get(0)).isEqualTo(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void getProfitTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoGameResult lottoGameResult = new LottoGameResult(lottos, 4000);

        int profit = lottoGameResult.getProfit(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(profit).isEqualTo(2001555000);
    }

/*    @Test
    public void getProfitPercentageTest() {

    }*/
}
