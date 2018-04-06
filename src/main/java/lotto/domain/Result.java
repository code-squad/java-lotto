package lotto.domain;

public class Result {
    private Match match;
    private int count;

    Result(Match match, int count) {
        this.match = match;
        this.count = count;
    }

    public boolean isOfMatch(Match match) {
        return this.match == match;
    }

    public Match getMatch() {
        return match;
    }

    public int getCount() {
        return count;
    }

    public int calculatePrize() {
        return match.calculatePrize(count);
    }
}
