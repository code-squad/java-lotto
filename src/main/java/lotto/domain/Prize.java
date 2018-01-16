package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public enum Prize {

    FIRST(2000000000), SECOND(1500000), THIRD(50000), FOURTH(5000), NONE(0);

    int reward;

    Prize(int reward) {
        this.reward = reward;
    }
}
