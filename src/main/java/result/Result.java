package result;

import rank.Rank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Result {
    public static HashMap<Rank, Integer> finalResult;
    private List<Rank> ranks;

    static {
        finalResult = new HashMap<>();
        finalResult.put(Rank.FIFTH, 0);
        finalResult.put(Rank.FOURTH, 0);
        finalResult.put(Rank.THIRD, 0);
        finalResult.put(Rank.SECOND, 0);
        finalResult.put(Rank.FIRST, 0);
        finalResult.put(Rank.NONE, 0);
    }

    public Result(List<Rank> ranks) {
        this.ranks = ranks;
        for (Rank rank: ranks) {
            int num = finalResult.get(rank);
            finalResult.put(rank , ++num);
        }
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public static HashMap<Rank, Integer> getFinalResult() {
        return finalResult;
    }
}
