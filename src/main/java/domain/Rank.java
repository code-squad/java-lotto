package domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FAIL(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        for (Rank rank : values()) {
            if(rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return FAIL;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public long calculateTotalEarningMoney(int numOfWinner) {
        return winningMoney * numOfWinner;
    }
}
