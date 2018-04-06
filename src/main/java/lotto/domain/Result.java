package lotto.domain;

public class Result {
    private Match match;
    private int count;

    Result(Match match, int count) {
        this.match = match;
        this.count = count;
    }

    boolean isOfMatch(Match match) {
        return this.match == match;
    }

    int getCount() {
        return count;
    }

    int calculatePrize() {
        return match.calculatePrize(count);
    }

    public Match getMatch() {
        return match;
    }
}
