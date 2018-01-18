package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public enum Prize {

    FIRST(0, false, 2000000000),
    SECOND(1, true, 30000000),
    THIRD(1, false, 1500000),
    FOURTH(2, false, 50000),
    FIFTH(3, false, 5000),
    NONE(-1, false, 0);

    private int countOfDiff;
    private boolean needMatchBonus;
    private int reward;

    Prize(int countOfDiff, boolean needMatchBonus, int reward) {
        this.countOfDiff = countOfDiff;
        this.needMatchBonus = needMatchBonus;
        this.reward = reward;
    }

    public static Prize checkWinning(LottoNumber lottoNumber, WinningNumber winningNumber) {
        int diff = LottoNumber.LOTTO_NUMBERS_SIZE - lottoNumber.countMatchNumber(winningNumber.getLottoNumber());
        boolean isMatchBonus = lottoNumber.contains(winningNumber.getBonusNumber());
        for(Prize prize: values()) {
            if (prize.checkWinningRule(diff) && prize.checkBonusRule(isMatchBonus))
                return prize;
        }
        return NONE;
    }

    private boolean checkWinningRule(int diff) {
        return countOfDiff == diff;
    }

    private boolean checkBonusRule(boolean match) {
        if(needMatchBonus && !match)
            return false;
        return true;
    }

    public int getCountOfDifference() {
        return countOfDiff;
    }

    public int getReward() {
        return reward;
    }
}
