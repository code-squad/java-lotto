package domain;

// 추후 사용하기 위해 미리 작성
public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonus;

    private Rank(int countOfMatch, int winningMoney, boolean bonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonus = bonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRank(int matchedCount, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.isMatched(matchedCount, bonus)) {
                return rank;
            }
        }
        return null; // Exception을 발생시킬지 말지
    }

    public boolean isMatched(int matchedCount, boolean bonus) {
        if (this.getCountOfMatch() == matchedCount && this.getBonus() == bonus) {
            return true;
        }
        return false;
    }

    public boolean getBonus() {
        return this.bonus;
    }
}