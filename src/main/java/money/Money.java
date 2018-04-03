package money;

import rank.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Money {
    private int profit;
    public static HashMap<Rank, Integer> finalCount;
    static {
        finalCount = new HashMap<>();
        finalCount.put(Rank.FIFTH, 0);
        finalCount.put(Rank.FOURTH, 0);
        finalCount.put(Rank.THIRD, 0);
        finalCount.put(Rank.SECOND, 0);
        finalCount.put(Rank.FIRST, 0);
        finalCount.put(Rank.NONE, 0);
    }

    public static HashMap<Rank, Integer> getFinalCount() {
        return finalCount;
    }

    public int getFirst() {
        return finalCount.get(Rank.FIRST);
    }

    public int getSecond() {
        return finalCount.get(Rank.SECOND);
    }

    public int getThird() {
        return finalCount.get(Rank.THIRD);
    }

    public int getFourth() {
        return finalCount.get(Rank.FOURTH);
    }

    public int getFifth() {
        return finalCount.get(Rank.FIFTH);
    }

    public HashMap<Rank, Integer> money(List<Rank> ranks) {
        for(int i = 0; i < ranks.size(); i++) {
            int num = finalCount.get(ranks.get(i));
            finalCount.put(ranks.get(i), ++num);
        }
        return finalCount;
    }

    public Integer totalMoney(List<Rank> ranks) {
        int sum = 0;
        for(int i = 0; i < ranks.size(); i++)
            sum += ranks.get(i).getWinningMoney();
        return sum;
    }

    public Integer profit(int profit, int output) {
        return (profit / output) * 100;
    }

    public int getProfit() {
        return profit;
    }
}