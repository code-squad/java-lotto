package domain;

// 추후 사용하기 위해 미리 작성
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

    public static Rank isRank(int matchedCount) {
        for (Rank rank : Rank.values()) {
            if (rank.isMatched(matchedCount)) {
                return rank;
            }
        }
        return null; // Exception을 발생시킬지 말지
    }

    public boolean isMatched(int matchedCount) {
        return this.getCountOfMatch() == matchedCount;
    }
}
