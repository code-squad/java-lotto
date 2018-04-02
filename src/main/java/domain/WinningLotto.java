package domain;

import domain.exceptions.DuplicatedBallException;

import java.util.List;

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

}
