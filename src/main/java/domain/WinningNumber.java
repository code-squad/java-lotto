package domain;

import enums.LottoPrize;

import java.util.List;

import static domain.LottoNumCreator.LOTTO_POOL_MAX_NUM;
import static domain.LottoNumCreator.LOTTO_POOL_NUM;

public class WinningNumber {
    private List<Integer> winningLottos;
    private int bonusNum;

    public WinningNumber(List<Integer> winningLottos, int bonusNum) {
        if(inputValidationCheck(winningLottos, bonusNum))
            throw new IllegalArgumentException("invalid input");

        this.winningLottos = winningLottos;
        this.bonusNum = bonusNum;
    }

    public LottoPrize matchLottoAndGetPrize(Lotto lotto) {
        int numOfCorrespond = lotto.howManyCorrespond(winningLottos);
        boolean matchBonusNum = lotto.isBonusNumMatch(bonusNum);

        return LottoPrize.valueOf(numOfCorrespond, matchBonusNum);
    }

    private boolean inputValidationCheck(List<Integer> winningLottos, int bonusNum) {
        return winningLottos == null || winningLottos.size() < LOTTO_POOL_NUM
                || bonusNum < 1 || bonusNum > LOTTO_POOL_MAX_NUM;
    }

    public List<Integer> getWinningLottos() {
        return winningLottos;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
