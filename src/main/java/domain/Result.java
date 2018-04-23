package domain;

import java.util.Map;

public class Result {
    private Map<Rank, Integer> result;

    public Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int getFirst() {
        return result.get(Rank.FIRST);
    }

    public int getSecond() {
        return result.get(Rank.SECOND);
    }

    public int getThird() {
        return result.get(Rank.THIRD);
    }

    public int getFourth() {
        return result.get(Rank.FOURTH);
    }

    public int getFifth() {
        return result.get(Rank.FIFTH);
    }
}
