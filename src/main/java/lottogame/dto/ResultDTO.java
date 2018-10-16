package lottogame.dto;

import lottogame.domain.PrizeRank;

import java.util.Map;

public class ResultDTO {
    private Map<PrizeRank, Integer> map;

    public ResultDTO(Map<PrizeRank, Integer> map) {
        this.map = map;
    }

    public int getHitCountOf(PrizeRank reward) {
        return map.get(reward);
    }
}
