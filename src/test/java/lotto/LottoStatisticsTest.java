package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningTier;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoStatisticsTest {
    private List<Lotto> lottos = new ArrayList();
    private List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private Lotto firstTier = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    private Lotto secondTier = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
    private Lotto thirdTier = new Lotto(Arrays.asList(3, 4, 5, 6, 10, 20));
    private Lotto fourthTier = new Lotto(Arrays.asList(4, 5, 6, 10, 20, 30));

    @Test
    public void 당첨확인_1등() {
        lottos.add(firstTier);

        LottoGame lottoGame = new LottoGame(lottos);
        LottoStatistics statistics = new LottoStatistics(lottoGame, winningNumbers);

        assertThat(statistics.count(WinningTier.FIRST)).isEqualTo(1);
    }

    @Test
    public void 당첨확인_2등() {
        lottos.add(secondTier);
        lottos.add(secondTier);

        LottoGame lottoGame = new LottoGame(lottos);
        LottoStatistics statistics = new LottoStatistics(lottoGame, winningNumbers);

        assertThat(statistics.count(WinningTier.SECOND)).isEqualTo(2);
    }

    @Test
    public void 당첨확인_3등() {
        lottos.add(thirdTier);
        lottos.add(thirdTier);

        LottoGame lottoGame = new LottoGame(lottos);
        LottoStatistics statistics = new LottoStatistics(lottoGame, winningNumbers);

        assertThat(statistics.count(WinningTier.THIRD)).isEqualTo(2);
    }

    @Test
    public void 당첨확인_4등() {
        lottos.add(fourthTier);
        lottos.add(fourthTier);
        lottos.add(fourthTier);

        LottoGame lottoGame = new LottoGame(lottos);
        LottoStatistics statistics = new LottoStatistics(lottoGame, winningNumbers);

        assertThat(statistics.count(WinningTier.FOURTH)).isEqualTo(3);
    }

    @After
    public void setup() {
        lottos.clear();
    }
}
