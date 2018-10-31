package com.zingoworks.lotto.model;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private int countOfHit;
    private boolean isBonusHit;
    private int winningMoney;

    Prize(int countOfHit, boolean isBonusHit, int winningMoney) {
        this.countOfHit = countOfHit;
        this.isBonusHit = isBonusHit;
        this.winningMoney = winningMoney;
    }

    public int getCountOfHit() {
        return countOfHit;
    }

    public boolean isBonusHit() {
        return isBonusHit;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getEarnedMoney(int totalWinnings) {
        return winningMoney * totalWinnings;
    }

    public static Prize of(int countOfHit, boolean isBonusHit) {
        for (Prize prize : Prize.values()) {
            if (countOfHit == SECOND.countOfHit) {
                return isBonusHit ? SECOND : THIRD;
            }

            if (prize.countOfHit == countOfHit) {
                return prize;
            }
        }
        return null;
    }
}
