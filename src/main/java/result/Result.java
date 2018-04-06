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

    public int getFirst() {
        return finalResult.get(Rank.FIRST);
    }

    public int getSecond() {
        return finalResult.get(Rank.SECOND);
    }

    public int getThird() {
        return finalResult.get(Rank.THIRD);
    }

    public int getFourth() {
        return finalResult.get(Rank.FOURTH);
    }

    public int getFifth() {
        return finalResult.get(Rank.FIFTH);
    }
}
