package lotto.domain;

import java.util.Arrays;

public enum Rank {

    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private static final int WINNING_MIN_COUNT = 3;

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

    public boolean isBonus() {
        return bonus;
    }

    public static Rank valueOf(int matches, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == matches && rank.bonus == isBonus)
                .findFirst()
                .orElse(Rank.MISS);
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }


}
