package lotto;

import lotto.vo.BonusNumber;

class WinningLotto {
    private Lotto winLotto;
    private BonusNumber bonusNumber;

    WinningLotto(Lotto winLotto, BonusNumber bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    Rank rank(Lotto lotto) {
        return Rank.valueOf(lotto.matchCount(winLotto), lotto.matchBonus(bonusNumber));
    }
}
