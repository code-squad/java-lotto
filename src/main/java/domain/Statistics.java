package domain;

import dto.StatisticsDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.Lotto.LOTTO_PRICE;

public class Statistics {
    private Map<Rank, Integer> rankCount;
    private int totalRateOfReturn;

    public Statistics(List<Lotto> lottos, Lotto winningLotto) {
        this.rankCount = calculateRankCount(lottos, winningLotto);
        this.totalRateOfReturn = calculateTotalRateOfReturn(lottos.size());
    }

    // TODO : 리턴시 없는 값은 null 대신 0 반환
    private Map<Rank, Integer> calculateRankCount(List<Lotto> lottos, Lotto winningLotto) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            int count = lotto.countNumberOfMatch(winningLotto);
            Rank rank = Rank.valueOf(count);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    private int calculateTotalRateOfReturn(int numOfLotto) {
        long sum = 0;
        for (Rank value : Rank.values()) {
            sum += value.calculateTotalEarningMoney(rankCount.getOrDefault(value, 0));
        }
        return (int) (sum / (numOfLotto * LOTTO_PRICE));
    }

    public StatisticsDto toDto() {
        return new StatisticsDto(rankCount, totalRateOfReturn);
    }
}
