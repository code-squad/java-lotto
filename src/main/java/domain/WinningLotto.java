package domain;

import dto.StatisticsDto;
import vo.LottoNumber;
import vo.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public StatisticsDto calculateWinningCount(List<Lotto> lottos) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(value -> rankCount.put(value, 0));

        for (Lotto lotto : lottos) {
            int count = lotto.countNumberOfMatch(winningLotto);
            boolean matchBonus = lotto.hasBonusNumber(bonusNumber);
            calculateEachLottoWinningCount(rankCount, count, matchBonus);
        }

        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setRankCount(rankCount);
        return statisticsDto;
    }

    private void calculateEachLottoWinningCount(Map<Rank, Integer> rankCount, int count, boolean matchBonus) {
        Rank rank = Rank.valueOf(count, matchBonus);
        rankCount.put(rank, rankCount.get(rank) + 1);
    }
}
