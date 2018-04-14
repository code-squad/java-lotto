package lotto;

import lotto.domain.*;
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

    private LottoTicket lottoTickets;

    @Before
    public void setup() {
        List<Lotto> lottos = new ArrayList();

        Lotto FIRST_TIER = Lotto.of(1, 2, 3, 4, 5, 6);
        Lotto SECOND_TIER = Lotto.of(1, 2, 3, 4, 5, 10);
        Lotto THIRD_TIER = Lotto.of(3, 4, 5, 6, 10, 20);
        Lotto FOURTH_TIER = Lotto.of(4, 5, 6, 10, 20, 30);
        Lotto FAIL_TIER = Lotto.of(11, 12, 13, 14, 15, 16);

        lottos.add(FIRST_TIER);
        lottos.add(SECOND_TIER);
        lottos.add(THIRD_TIER);
        lottos.add(FOURTH_TIER);
        lottos.add(FAIL_TIER);

        this.lottoTickets = new LottoTicket(lottos);
    }

    @Test
    public void 당첨내역_확인_1개() {
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.of(10));

        int count = this.lottoTickets.countOfWinningLotto(Rank.FIRST, winningLotto);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 당첨내역_확인_없음() {
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(15, 16, 17, 18, 19, 20), LottoNumber.of(10));

        int count = this.lottoTickets.countOfWinningLotto(Rank.MISS, winningLotto);

        assertThat(count).isEqualTo(5);
    }

    @Test
    public void 결과조회() {
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(14, 15, 16, 17, 18, 19), LottoNumber.of(10));

        LottoResult result = this.lottoTickets.createResult(winningLotto);

        assertThat(result.get(Rank.FIRST)).isEqualTo(0);
        assertThat(result.get(Rank.SECOND)).isEqualTo(0);
        assertThat(result.get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.MISS)).isEqualTo(4);
    }

    @After
    public void teardown() {
        this.lottoTickets = null;
    }
}
