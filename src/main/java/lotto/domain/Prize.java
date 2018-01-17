package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public enum Prize {

    FIRST(1, 2000000000), SECOND(2, 1500000), THIRD(3, 50000), FOURTH(4, 5000), NONE(-1, 0);

    private int prizeNumber;
    private int reward;

    Prize(int prizeNumber, int reward) {
        this.prizeNumber = prizeNumber;
        this.reward = reward;
    }

    public int getPrizeNumber() {
        return prizeNumber;
    }

    public int getReward() {
        return reward;
    }
}
