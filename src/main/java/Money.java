import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Money {
    static ArrayList<Integer> totalMoney = new ArrayList<>();
    static HashMap<Integer, Integer> finalCount;
    List<Integer> addMoney = Arrays.asList(5000, 50000, 1500000, 2000000000);

    static {
        finalCount = new HashMap<Integer, Integer>();
        finalCount.put(Rank.FOURTH.getCountOfMatch(), 0);
        finalCount.put(Rank.THIRD.getCountOfMatch(), 0);
        finalCount.put(Rank.SECOND.getCountOfMatch(), 0);
        finalCount.put(Rank.FIRST.getCountOfMatch(), 0);
    }

    public void money(ArrayList<Integer> counts) {
        for(int i = 0; i < counts.size(); i++) {
            countAdd(counts, i);
        }
    }

    public ArrayList<Integer> countAdd(ArrayList<Integer> counts, int i) {
        int num = counts.get(i);
        if (num > 2) {
            int value = finalCount.get(num);
            totalMoney.add(addMoney.get(num - 3));
            finalCount.put(num, ++value);
        }
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

