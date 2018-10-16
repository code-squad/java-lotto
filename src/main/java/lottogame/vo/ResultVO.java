package lottogame.vo;

import lottogame.domain.PrizeRank;

import java.util.Map;

public class ResultVO {
    private Map<PrizeRank, Integer> map;

    public ResultVO(Map<PrizeRank, Integer> map) {
        this.map = map;
    }

    public int hitCountOf(PrizeRank reward) {
        return map.get(reward);
    }
}
