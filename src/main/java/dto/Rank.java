package dto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FAIL(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        if (countOfMatch < 0 || countOfMatch > 6) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(Rank.values())
                     .filter(r -> r.getCountOfMatch() == countOfMatch)
                     .findFirst()
                     .orElse(FAIL);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isFail() {
        return this == Rank.FAIL;
    }
}
