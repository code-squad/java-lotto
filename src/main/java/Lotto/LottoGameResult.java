package Lotto;

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

    public static int getYield(int money) {
        return Math.round(totalYieldMoney() / money * 100);
    }

    public static float totalYieldMoney() {
        return Rank.FIRST.getWinningMoney() * prizeCounts.get(Rank.FIRST)
                + Rank.SECOND.getWinningMoney() * prizeCounts.get(Rank.SECOND)
                + Rank.THIRD.getWinningMoney() * prizeCounts.get(Rank.THIRD)
                + Rank.FOURTH.getWinningMoney() * prizeCounts.get(Rank.FOURTH)
                + Rank.FIFTH.getWinningMoney() * prizeCounts.get(Rank.FIFTH);
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