package domain;

import dto.WinStatsDto;
import vo.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinStats {
    private Map<Rank, Integer> winStats;
    private double earningRate;
    {
        earningRate = 0.0;
        winStats = new HashMap<>();
        winStats.put(Rank.FIRST, 0);
        winStats.put(Rank.SECOND, 0);
        winStats.put(Rank.THIRD, 0);
        winStats.put(Rank.FOURTH, 0);
        winStats.put(Rank.FIFTH, 0);
    }

    void countRank(Rank rank){
        if(rank != null){
            this.winStats.replace(rank, this.winStats.get(rank) + 1);
        }
    }

    void calculateEarningRate(int investedMoney){
        double earningMoney = 0.0;
        for (Rank rank : Rank.values()) {
            earningMoney += rank.calculateTotalReward(this.winStats.get(rank));
        }
        this.earningRate = earningMoney / (investedMoney) * 100;
    }

    public WinStatsDto toDto(){
        return new WinStatsDto(this.winStats, this.earningRate);
    }

}
