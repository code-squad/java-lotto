package javaLotto.domain;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false);

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        for (Rank rank : values()) {
            if (countOfMatch == rank.THIRD.getCountOfMatch()) return matchBonus ? SECOND : THIRD;
            if (countOfMatch == rank.countOfMatch) {
                return rank;
            }
        }
        return MISS;
    }



}