package dto;

import domain.Rank;

import java.util.Map;

public class StatisticsDto {
    private Map<Rank, Integer> rankCount;
    private int totalRateOfReturn;

    public StatisticsDto(Map<Rank, Integer> rankCount, int totalRateOfReturn) {
        this.rankCount = rankCount;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public int getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
