package domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatsCalculatorTest {

    @Test
    public void WinStatsCalculator() {
        List<Lotto> randomLottoBundle = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 9, 10, 11));

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLotto theWinningLotto = LottoFactory.generateWinningLotto(set, 7);

        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set1));
        randomLottoBundle.add(LottoFactory.generateTheLotto(set2));


        WinStatsCalculator wc = new WinStatsCalculator(randomLottoBundle, theWinningLotto);
        assertThat(wc.calculateEarningRate()).isEqualTo(100.0);
    }

}
