package domain;

import domain.result.LottoNum;

public class WinningLotto {
    private Lotto lotto;
    private LottoNum bonusNum;

    public WinningLotto(Lotto lotto, LottoNum bonusNum) {
        if (lotto.isContainNumber(bonusNum)) {
            throw new IllegalArgumentException("보너스번호가 당첨번호로 지정된 번호입니다.");
        }
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public int match(Lotto otherLotto) {
        return lotto.match(otherLotto);
    }

    public boolean matchBonus(Lotto otherLotto) {
        return otherLotto.isContainNumber(bonusNum);
    }

    @Override
    public String toString() {
        return "WinningLotto{" + "lotto=" + lotto.toString() + ", bonusNumber=" + bonusNum + '}';
    }
}
