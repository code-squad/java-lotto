package lotto;

import java.util.*;

public class Reward {
    private Map<Rank, Integer> gameResult;

    public Map<Rank, Integer> getInitReward() {
        gameResult = new HashMap<>();
        gameResult.put(Rank.FIRST, 0);
        gameResult.put(Rank.SECOND, 0);
        gameResult.put(Rank.THIRD, 0);
        gameResult.put(Rank.FOURTH, 0);
        gameResult.put(Rank.FIFTH, 0);
        return gameResult;
    }

    public double earningRate(Map<Rank,Integer> gameResult) {
        this.gameResult = gameResult;
        double rewardPrice = 0;
        for (Rank lottoRank : this.gameResult.keySet()) {
            rewardPrice += lottoRank.getWinningMoney() * this.gameResult.get(lottoRank);
        }
        return rewardPrice;
    }
}
