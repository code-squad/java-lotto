package domain;

import dto.StatisticsDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.Lotto.LOTTO_PRICE;

public class Statistics {
    private Map<Rank, Integer> rankCount;
    private int totalRateOfReturn;

    public Statistics(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        this.rankCount = calculateRankCount(lottos, winningLotto, bonusNumber);
        this.totalRateOfReturn = calculateTotalRateOfReturn(lottos.size());
    }

    private Map<Rank, Integer> calculateRankCount(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(value -> rankCount.put(value, 0));

        for (Lotto lotto : lottos) {
            int count = lotto.countNumberOfMatch(winningLotto);
            boolean matchBonus = lotto.hasBonusNumber(bonusNumber);
            calculateEachLottoRank(rankCount, count, matchBonus);
        }

        return rankCount;
    }

    private void calculateEachLottoRank(Map<Rank, Integer> rankCount, int count, boolean matchBonus) {
        Rank rank = Rank.valueOf(count, matchBonus);
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    private int calculateTotalRateOfReturn(int numOfLotto) {
        long sum = 0;
        for (Rank value : Rank.values()) {
            sum += value.calculateTotalEarningMoney(rankCount.get(value));
        }
        return (int) (sum / (numOfLotto * LOTTO_PRICE));
    }

    public StatisticsDto toDto() {
        return new StatisticsDto(rankCount, totalRateOfReturn);
    }
}
