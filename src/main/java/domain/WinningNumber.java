package domain;

import enums.LottoPrize;

import java.util.List;

import static domain.LottoNumCreator.LOTTO_POOL_NUM;

public class WinningNumber {
    private List<LottoNo> winningLottos;
    private LottoNo bonusNum;

    public WinningNumber(List<LottoNo> winningLottos, LottoNo bonusNum) {
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

    private boolean inputValidationCheck(List<LottoNo> winningLottos, LottoNo bonusNum) {
        return winningLottos == null || winningLottos.size() < LOTTO_POOL_NUM
                || !bonusNum.isValid();
    }

    public List<LottoNo> getWinningLottos() {
        return winningLottos;
    }

    public LottoNo getBonusNum() {
        return bonusNum;
    }
}
