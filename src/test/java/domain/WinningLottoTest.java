package domain;

import dto.StatisticsDto;
import org.junit.Test;
import vo.LottoNumber;
import vo.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void 등수별_당첨수() {
        //when
        Lotto first = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(first, bonusNumber);

        Lotto second = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        Lotto fifth = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        Lotto fail = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(first, second, second, fifth, fail, fail));

        //when
        StatisticsDto dto = winningLotto.calculateWinningCount(lottos);

        //then
        Map<Rank, Integer> rankCount = dto.getRankCount();
        assertThat(rankCount.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCount.get(Rank.SECOND)).isEqualTo(2);
        assertThat(rankCount.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankCount.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankCount.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankCount.get(Rank.FAIL)).isEqualTo(2);
    }
}