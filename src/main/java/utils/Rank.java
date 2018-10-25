package utils;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THRID(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int countOfStrike;
    private int winningMoney;

    private Rank(int countOfStrike, int winningMoney) {
        this.countOfStrike = countOfStrike;
        this.winningMoney = winningMoney;
    }

    public boolean isEqual(int target) {
        return countOfStrike == target;
    }

    public int getCountOfStrike() {
        return countOfStrike;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int strikePoint, boolean strikeBonus) {
        for (Rank rank : values()) {
            if (strikePoint == SECOND.countOfStrike) {
                return strikeBonus ? SECOND : THRID;
            }

            if (rank.isEqual(strikePoint)) {
                return rank;
            }
        }
        return null;
    }
}

