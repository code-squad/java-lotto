package dto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000) {
        @Override
        public boolean isMatchBonus() {
            return true;
        }
    },
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 0 || countOfMatch > 6) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(Rank.values())
                     .filter(r -> r.isSameMatchCountAndBonus(countOfMatch, matchBonus))
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

    private boolean isSameMatchCountAndBonus(int countOfMatch, boolean matchBonus) {
        return getCountOfMatch() == countOfMatch && isMatchBonus() == matchBonus;
    }

    public boolean isMatchBonus() {
        return false;
    }
}
