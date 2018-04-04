package domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRank(int matchedCount) {
        for (Rank rank : Rank.values()) {
            if (rank != SECOND && rank.isMatched(matchedCount)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("순위를 벗어났습니다.");
    }

    private boolean isMatched(int matchedCount) {
        return this.getCountOfMatch() == matchedCount;
    }
}