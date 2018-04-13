package javaLotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

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