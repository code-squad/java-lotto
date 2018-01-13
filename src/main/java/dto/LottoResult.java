package dto;

public class LottoResult {

    private final Rank rank;

    private final int countOfMatch;

    public LottoResult(int countOfMatch) {
        if (countOfMatch < 0) {
            throw new IllegalArgumentException();
        }
        this.countOfMatch = countOfMatch;
        this.rank = Rank.valueOf(countOfMatch);
    }

    public Rank getRank() {
        return rank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return rank.getWinningMoney();
    }
}
