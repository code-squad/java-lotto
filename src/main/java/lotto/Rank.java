package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMonty) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMonty;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (isMatchSecondRank(countOfMatch, matchBonus)) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if( rank.countOfMatch == countOfMatch ) {
                return rank;
            }
        }

        return MISS;
    }

    private static boolean isMatchSecondRank(int countOfMatch, boolean matchBonus) {
        return countOfMatch == SECOND.countOfMatch && matchBonus;
    }
}
