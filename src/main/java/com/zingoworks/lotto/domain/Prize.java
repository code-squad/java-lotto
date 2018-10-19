package com.zingoworks.lotto.domain;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int countOfHit;
    private int winningMoney;

    Prize(int countOfHit, int winningMoney) {
        this.countOfHit = countOfHit;
        this.winningMoney = winningMoney;
    }

    public int getCountOfHit() {
        return countOfHit;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}