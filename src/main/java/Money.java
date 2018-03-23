import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Money {
    static ArrayList<Integer> totalMoney = new ArrayList<>();
    static HashMap<Rank, Integer> finalCount;
    static {
        finalCount = new HashMap<>();
        finalCount.put(Rank.FIFTH, 0);
        finalCount.put(Rank.FOURTH, 0);
        finalCount.put(Rank.THIRD, 0);
        finalCount.put(Rank.SECOND, 0);
        finalCount.put(Rank.FIRST, 0);
    }

    public void money(ArrayList<Rank> ranks) {
        for(int i = 0; i < ranks.size(); i++) {
            countAdd(ranks, i);
        }
    }

    public ArrayList<Integer> countAdd(ArrayList<Rank> ranks, int i) {
        int num = finalCount.get(ranks.get(i));
        totalMoney.add(ranks.get(i).getWinningMoney());
        finalCount.put(ranks.get(i) , ++num);
        return totalMoney;
    }

    public Integer totalMoney(ArrayList<Integer> totalMoney) {
        int sum = 0;
        for(int i = 0; i < totalMoney.size(); i++)
            sum += totalMoney.get(i);
        return sum;
    }

    public Integer profit(int profit, int output) {
        return (profit / output) * 100;
    }
}