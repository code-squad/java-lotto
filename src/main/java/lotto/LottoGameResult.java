package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {

    private static Map<Rank, Integer> prizeCounts;

    static {
        prizeCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            prizeCounts.put(rank, 0);
        }
    }

    public static int getYield(Money money) {
        return Math.round(money.rateOfReturn(totalYieldMoney()));
    }

    public static float totalYieldMoney() {
        float total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getWinningMoney() * prizeCounts.get(rank);
        }

        return total;
    }

    public static void setPrizeCount(Rank rank) {
        int count = prizeCounts.get(rank);
        prizeCounts.put(rank, ++count);
    }

    public int getFirstPrizeCount() {
        return prizeCounts.get(Rank.FIRST);
    }

    public int getSecondPrizeCount() {
        return prizeCounts.get(Rank.SECOND);
    }

    public int getThirdPrizeCount() {
        return prizeCounts.get(Rank.THIRD);
    }

    public int getFourthPrizeCount() {
        return prizeCounts.get(Rank.FOURTH);
    }

    public int getFifthPrizeCount() {
        return prizeCounts.get(Rank.FIFTH);
    }

}