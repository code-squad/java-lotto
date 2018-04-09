package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStatisticsTest {

    @Test
    public void test_5등_3개일치_갯수() {

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 9, 10, 11);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, luckyNumbers);

        assertThat(lottoStatistics.result.get(3)).isEqualTo(4);
    }

    @Test
    public void test_4등_4개일치_갯수() {

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 20, 21, 22)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 20, 21, 22)));

        List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 4, 9, 11);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, luckyNumbers);

        assertThat(lottoStatistics.result.get(4)).isEqualTo(2);
    }

    @Test
    public void test_당첨금액_수익률_30_퍼센트() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(11, 12, 13, 14, 15, 16)));
        lottos.add(new Lotto(() -> Arrays.asList(11, 12, 13, 14, 15, 16)));

        List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 40, 41, 42);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, luckyNumbers);

        assertThat(lottoStatistics.rateOfReturn(14000)).isEqualTo(35);
    }

    @Test
    public void test_당첨금액_수익률_500_퍼센트() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(11, 12, 13, 14, 15, 16)));
        lottos.add(new Lotto(() -> Arrays.asList(11, 12, 13, 14, 15, 16)));

        List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 4, 41, 42);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, luckyNumbers);

        assertThat(lottoStatistics.rateOfReturn(10000)).isEqualTo(500);
    }

    @Test
    public void getMatchNumberTest() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 9, 10, 11);

        assertThat(LottoStatistics.getMatchNumber(luckyNumbers, lotto)).isEqualTo(3);
    }

    @Test
    public void getTotalTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 9, 10, 11);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, luckyNumbers);

        assertThat(lottoStatistics.getTotal()).isEqualTo(20000);
    }

    @Test
    public void trimTEst() {
        System.out.println("a, aa,   a".replace("  ", ""));
    }
}
