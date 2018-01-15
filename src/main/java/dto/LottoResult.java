package dto;

public class LottoResult {

    private final Rank rank;

    private final int countOfMatch;

    public LottoResult(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 0 || countOfMatch > 6) {
            throw new IllegalArgumentException();
        }
        this.countOfMatch = countOfMatch;
        this.rank = Rank.valueOf(countOfMatch, matchBonus);
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
