package money;

import rank.Rank;

import java.util.ArrayList;
import java.util.HashMap;

public class Money {
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
    
    public void money(ArrayList<Rank> ranks) {
        for(int i = 0; i < ranks.size(); i++) {
            int num = finalCount.get(ranks.get(i));
            finalCount.put(ranks.get(i), ++num);
        }
    }

    public Integer totalMoney(ArrayList<Rank> ranks) {
        int sum = 0;
        for(int i = 0; i < ranks.size(); i++)
            sum += ranks.get(i).getWinningMoney();
        return sum;
    }

    public Integer profit(int profit, int output) {
        return (profit / output) * 100;
    }
}