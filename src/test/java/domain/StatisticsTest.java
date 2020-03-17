package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @Test
    public void 통계생성_등수별당첨자수() {
        //given
        Lotto winningLotto = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        Lotto third = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))));
        Lotto fail = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(winningLotto, third, third, fail));

        //when
        Statistics statistics = new Statistics(lottos, winningLotto);

        //then
        assertThat(statistics.toDto().getRankCount().get(Rank.FIRST)).isEqualTo(1);
        assertThat(statistics.toDto().getRankCount().get(Rank.SECOND)).isEqualTo(null);
        assertThat(statistics.toDto().getRankCount().get(Rank.THIRD)).isEqualTo(2);
        assertThat(statistics.toDto().getRankCount().get(Rank.FOURTH)).isEqualTo(null);
        assertThat(statistics.toDto().getRankCount().get(Rank.FAIL)).isEqualTo(1);
    }

    @Test
    public void 통계생성_총수익률() {
        //given
        Lotto winningLotto = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        Lotto third = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))));
        Lotto fail = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(winningLotto, third, third, fail));
        int expectedTotalYields = (Rank.FIRST.getWinningMoney() + 2 * (Rank.THIRD.getWinningMoney()))
                / (lottos.size() * LOTTO_PRICE);

        //when
        Statistics statistics = new Statistics(lottos, winningLotto);

        //then
        assertThat(statistics.toDto().getTotalRateOfReturn()).isEqualTo(expectedTotalYields);
    }
}
