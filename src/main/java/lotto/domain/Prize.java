package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public enum Prize {

    FIRST(0, 2000000000),
    SECOND(1, 30000000),
    THIRD(1, 1500000),
    FOURTH(2, 50000),
    FIFTH(3, 5000),
    NONE(-1, 0);

    private int countOfDiff;
    private int reward;

    Prize(int countOfDiff, int reward) {
        this.countOfDiff = countOfDiff;
        this.reward = reward;
    }

    public boolean checkWinningRule(int diff) {
        return countOfDiff == diff;
    }

    public boolean checkBonusRule(boolean match) {
        return (this != SECOND) || match;
    }

    public int getCountOfDifference() {
        return countOfDiff;
    }

    public int getReward() {
        return reward;
    }
}
