package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinningTier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoGameTest {
    private List<Lotto> lottos = new ArrayList();

    @Before
    public void setup() {
        Lotto FIRST_TIER = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto SECOND_TIER = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        Lotto THIRD_TIER = new Lotto(Arrays.asList(3, 4, 5, 6, 10, 20));
        Lotto FOURTH_TIER = new Lotto(Arrays.asList(4, 5, 6, 10, 20, 30));
        Lotto FAIL_TIER = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        this.lottos.add(FIRST_TIER);
        this.lottos.add(SECOND_TIER);
        this.lottos.add(THIRD_TIER);
        this.lottos.add(FOURTH_TIER);
        this.lottos.add(FAIL_TIER);
    }

    @Test
    public void 당첨내역_확인_1개() {
        LottoGame lottoGame = new LottoGame(lottos);
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int count = lottoGame.winningLottoCount(WinningTier.FIRST, winningLotto);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 당첨내역_확인_없음() {
        LottoGame lottoGame = new LottoGame(lottos);
        Lotto winningLotto = new Lotto(Arrays.asList(15, 16, 17, 18, 19, 20));

        int count = lottoGame.winningLottoCount(WinningTier.FAIL, winningLotto);

        assertThat(count).isEqualTo(5);
    }

    @Test
    public void 결과조회() {
        LottoGame lottoGame = new LottoGame(lottos);
        Lotto winningLotto = new Lotto(Arrays.asList(14, 15, 16, 17, 18, 19));

        LottoResult result = lottoGame.createResult(winningLotto);

        assertThat(result.get(WinningTier.FIRST)).isEqualTo(0);
        assertThat(result.get(WinningTier.SECOND)).isEqualTo(0);
        assertThat(result.get(WinningTier.THIRD)).isEqualTo(0);
        assertThat(result.get(WinningTier.FOURTH)).isEqualTo(1);
        assertThat(result.get(WinningTier.FAIL)).isEqualTo(4);
    }

    @After
    public void teardown() {
        this.lottos.clear();
    }
}
