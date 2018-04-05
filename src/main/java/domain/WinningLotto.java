package domain;

import domain.exceptions.DuplicatedBallException;

import java.util.List;
import java.util.Objects;

public class WinningLotto extends Lotto {

    private LottoNo bonusNum;

    private WinningLotto(LottoNoGroup winningLottoNoGroup, LottoNo bonusNum) {
        super(winningLottoNoGroup);
        if (!isValidBonus(winningLottoNoGroup, bonusNum)) {
            throw new DuplicatedBallException("중복된 번호는 넣을 수 없습니다. \n Winning number" + winningLottoNoGroup.toString() + "\n BonusBall : " + bonusNum.toString());
        }
        this.bonusNum = bonusNum;
    }

    public static WinningLotto of(LottoNoGroup lottoNoGroup, LottoNo lottoNo) {
        return new WinningLotto(lottoNoGroup, lottoNo);
    }

    static boolean isValidBonus(LottoNoGroup lottoNoGroup, LottoNo bonusNum) {
        return !lottoNoGroup.contains(bonusNum);
    }

    public boolean isBonus(LottoNoGroup lottoNoGroup) {
        return lottoNoGroup.contains(bonusNum);
    }

    public LottoNo getBonusNum() {
        return bonusNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(bonusNum, that.bonusNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), bonusNum);
    }
}
