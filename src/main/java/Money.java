import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Money {
    static ArrayList<Integer> totalMoney = new ArrayList<>();
    static HashMap<Rank, Integer> finalCount;
    List<Integer> addMoney = Arrays.asList(5000, 50000, 1500000, 2000000000);
    static {
        finalCount = new HashMap<>();
        finalCount.put(Rank.FIFTH, 0);
        finalCount.put(Rank.FOURTH, 0);
        finalCount.put(Rank.THIRD, 0);
        finalCount.put(Rank.SECOND, 0);
        finalCount.put(Rank.FIRST, 0);
    }

//    public void money(ArrayList<Integer> counts) {
//        for(int i = 0; i < counts.size(); i++) {
//            countAdd(counts, i);
//        }
//    }
//
//    public ArrayList<Integer> countAdd(ArrayList<Integer> counts, int i) {
//        int num = counts.get(i);
//        if (num > 2) {
//            int value = finalCount.get(Rank.valueOf(num, false));
//            totalMoney.add(addMoney.get(num - 3));
//            finalCount.put(Rank.valueOf(num, false), ++value);
//        }
//        return totalMoney;
//    }
//
//    public Integer totalMoney(ArrayList<Integer> totalMoney) {
//        int sum = 0;
//        for(int i = 0; i < totalMoney.size(); i++)
//            sum += totalMoney.get(i);
//        return sum;
//    }

    public void money(ArrayList<Rank> ranks) {
        for(int i = 0; i < ranks.size(); i++) {
            countAdd(ranks, i);
        }
    }

    public ArrayList<Integer> countAdd(ArrayList<Rank> ranks, int i) {
//        int num = ranks.get(i).getCountOfMatch();
        int num = 0;
        totalMoney.add(ranks.get(i).getWinningMoney());
        System.out.println("추가된 돈 : " + ranks.get(i).getWinningMoney());
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