package lotto.model;

public class MatchingResult {
    private final Rank rank;
    private int countOfMatchingLotto = 0;

    public MatchingResult(Rank rank) {
        this.rank = rank;
    }

    public boolean supports(Rank rank) {
        return this.rank == rank;
    }

    public int match() {
        countOfMatchingLotto++;
        return countOfMatchingLotto;
    }

    public Money prizePerRank() {
        return rank.prize(countOfMatchingLotto);
    }

    public String getDisplayText() {
        return rank.getDisplayText();
    }

    public int getCountOfMatchingLotto() {
        return countOfMatchingLotto;
    }
}
