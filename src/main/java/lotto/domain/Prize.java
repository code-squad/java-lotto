package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public enum Prize {

    FIRST(0, 2000000000), SECOND(1, 1500000), THIRD(2, 50000), FOURTH(3, 5000), NONE(-1, 0);

    private int countOfDiff;
    private int reward;

    Prize(int countOfDiff, int reward) {
        this.countOfDiff = countOfDiff;
        this.reward = reward;
    }

    public static Prize checkWinning(LottoNumber lottoNumber, LottoNumber winningNumber) {
        int diff = LottoNumber.LOTTO_NUMBERS_SIZE - lottoNumber.countMatchNumber(winningNumber);
        for(Prize prize: values()) {
            if (prize.countOfDiff == diff)
                return prize;
        }
        return NONE;
    }

    public int getCountOfDifference() {
        return countOfDiff;
    }

    public int getReward() {
        return reward;
    }
}
