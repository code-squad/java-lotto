package domain;

import enums.LottoPrize;

public class WinningNumber {
    private Lotto winningLottos;
    private LottoNo bonusNum;

    public WinningNumber(Lotto winningLottos, LottoNo bonusNum) {
        inputValidationCheck(winningLottos, bonusNum);

        this.winningLottos = winningLottos;
        this.bonusNum = bonusNum;
    }

    public LottoPrize matchLottoAndGetPrize(Lotto lotto) {
        int numOfCorrespond = lotto.howManyCorrespond(winningLottos);
        boolean matchBonusNum = lotto.isBonusNumMatch(bonusNum);

        return LottoPrize.valueOf(numOfCorrespond, matchBonusNum);
    }

    private void inputValidationCheck(Lotto winningLottos, LottoNo bonusNum) {
        if(winningLottos == null || bonusNum == null)
            throw new IllegalArgumentException("invalid input");
    }

    public Lotto getWinningLottos() {
        return winningLottos;
    }

    public LottoNo getBonusNum() {
        return bonusNum;
    }
}
