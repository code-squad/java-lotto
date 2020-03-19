package dto;

import vo.Rank;

import java.util.Map;

public class StatisticsDto {
    private Map<Rank, Integer> rankCount;

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public void setRankCount(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }
}
