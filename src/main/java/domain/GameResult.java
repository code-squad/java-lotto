package domain;

import utils.MathHandler;
import utils.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<String> getResultMessage() {
        List<String> resultMessage = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(rank.getCountOfStrike() + "개 일치");
            if(rank.equals(Rank.SECOND)) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (" + rank.getWinningMoney() + "원) ");
            sb.append("- " + gameResult.get(rank) + "개");
            resultMessage.add(sb.toString());
        }
        return resultMessage;
    }
}
