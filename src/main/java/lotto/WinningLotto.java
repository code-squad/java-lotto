package lotto;

import lotto.vo.LottoNumber;

class WinningLotto {
    private Lotto winLotto;
    private LottoNumber bonusNumber;

    WinningLotto(Lotto winLotto, LottoNumber bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    Rank rank(Lotto lotto) {
        return Rank.valueOf(lotto.matchCount(winLotto), lotto.matchBonus(bonusNumber));
    }
}
