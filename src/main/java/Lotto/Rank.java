package Lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 3) {
            return Rank.MISS;
        }

        if (countOfMatch == 5 && matchBonus) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(r -> r != SECOND)
                .filter(r -> r.checkCountOfMatch(countOfMatch))
                .findFirst().orElse(MISS);
    }

    public boolean checkCountOfMatch(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

}