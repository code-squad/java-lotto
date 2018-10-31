package domain;

import utils.MathHandler;
import utils.Rank;

import java.util.Map;

public class GameResult {
    private final Map<Rank, Integer> gameResult;

    public GameResult(Map<Rank, Integer> gameResult) {
        this.gameResult = gameResult;
    }

    public int calculateProfitRate(double purchaseAmount) {
        int tempProfitSum = 0;
        for (Rank rank : gameResult.keySet()) {
            tempProfitSum += Rank.findWinningMoney(rank) * gameResult.get(rank);
        }
        return MathHandler.getProfit(tempProfitSum, purchaseAmount);
    }

    public Map<Rank, Integer> getGameResult() {
        return gameResult;
    }
}
