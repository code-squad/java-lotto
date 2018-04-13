package lotto.domain;

public class BonusNumber {

    private LottoMeta bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = new LottoMeta(bonusNumber);
    }

    public boolean isMatchedBonusNumber(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}
