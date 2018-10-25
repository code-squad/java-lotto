package lottogame.dto;

import lottogame.domain.PrizeRank;

import java.util.Map;

public class Result {
    Map<PrizeRank, Integer> map;

    public Result(Map<PrizeRank, Integer> map) {
        this.map = map;
    }

    public Integer get(PrizeRank prizeRank) {
        return map.get(prizeRank);
    }

    public int totalReward(){
        int totalReward = 0;
        for (Integer value : map.values()) {
            totalReward += value;
        }
        return totalReward;
    }
}
