import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Money {
    static ArrayList<Integer> totalMoney = new ArrayList<>();
    static HashMap<String, Integer> finalCount;
    ArrayList<Integer> addMoney = new ArrayList<Integer>(Arrays.asList(5000, 50000, 1500000, 2000000000));

    static {
        finalCount = new HashMap<String, Integer>();
        finalCount.put("3", 0);
        finalCount.put("4", 0);
        finalCount.put("5", 0);
        finalCount.put("6", 0);
    }

    public void money(ArrayList<Integer> counts) {
        for(int i = 0; i < counts.size(); i++) {
            countAdd(counts, i);
        }
    }

    public ArrayList<Integer> countAdd(ArrayList<Integer> counts, int i) {
        int num = counts.get(i);
        String key = String.valueOf(num);
        if (num > 2) {
            int value = finalCount.get(key);
            totalMoney.add(addMoney.get(num - 3));
            finalCount.put(key, ++value);
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
