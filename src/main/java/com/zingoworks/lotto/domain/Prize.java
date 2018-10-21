package com.zingoworks.lotto.domain;

public enum Prize {
    FIRST(new Score(6, false), 2000000000),
    SECOND(new Score(5, true), 30000000),
    THIRD(new Score(5, false), 1500000),
    FOURTH(new Score(4, false), 50000),
    FIFTH(new Score(3, false), 5000);

    private Score score;
    private int winningMoney;

    Prize(Score score, int winningMoney) {
        this.score = score;
        this.winningMoney = winningMoney;
    }

    public Score getScore() {
        return score;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}