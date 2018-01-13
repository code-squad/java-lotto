package lotto;

public class Result {

    private final Rank rank;

    private final int countOfMatch;

    public Result(int countOfMatch) {
        this.countOfMatch = countOfMatch;
        this.rank = Rank.valueOf(countOfMatch);
    }

    public Rank getRank() {
        return rank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}
