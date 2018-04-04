package result;

import rank.Rank;

import java.util.HashMap;
import java.util.List;

public class Result {
    public static HashMap<Rank, Integer> finalResult;
    static {
        finalResult = new HashMap<>();
        finalResult.put(Rank.FIFTH, 0);
        finalResult.put(Rank.FOURTH, 0);
        finalResult.put(Rank.THIRD, 0);
        finalResult.put(Rank.SECOND, 0);
        finalResult.put(Rank.FIRST, 0);
        finalResult.put(Rank.NONE, 0);
    }

    public HashMap<Rank, Integer> insert(List<Rank> ranks) {
        for (Rank rank: ranks) {
            int num = finalResult.get(rank);
            finalResult.put(rank , ++num);
        }
        return finalResult;
    }

    public HashMap<Rank, Integer> getResult() {
        return finalResult;
    }
}
