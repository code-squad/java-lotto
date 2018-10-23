package dto;

import vo.Rank;

import java.util.Map;

public class WinStatsDto {
    private Map<Rank, Integer> winStats;
    private double earningRate;

    public WinStatsDto(Map<Rank, Integer> winStats, double earningRate) {
        this.winStats = winStats;
        this.earningRate = earningRate;
    }

    public int getNumberOfCounts(Rank rank){
        return winStats.get(rank);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
