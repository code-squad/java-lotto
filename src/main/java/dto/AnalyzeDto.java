package dto;

import domain.Rank;

import java.util.Map;

public class AnalyzeDto {
    private Map<Rank, Integer> rankCount;
    private int totalRateOfReturn;

    public AnalyzeDto(Map<Rank, Integer> rankCount, int totalRateOfReturn) {
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
