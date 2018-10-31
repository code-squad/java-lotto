package lotto;

import java.util.*;

public class Reward {
    private Map<Rank, Integer> gameResult = new HashMap<>();

    public Reward() {
        for (Rank rank : Rank.values()) {
            gameResult.put(rank,0);
        }
    }

    public void changeReward(Rank rank) {
        gameResult.put(rank, gameResult.get(rank) + 1);
    }

    public int outEachRewardCount(Rank rank) {
        return gameResult.get(rank);
    }

    public double earningRate() {
        double rewardPrice = 0;
        for (Rank rank : gameResult.keySet()) {
            rewardPrice += rank.getWinningMoney() * gameResult.get(rank);
        }
        return rewardPrice;
    }
}
