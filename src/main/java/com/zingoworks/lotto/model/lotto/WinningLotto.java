package com.zingoworks.lotto.model.lotto;

import com.zingoworks.lotto.model.Prize;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    Prize getPrize(Lotto lotto) {
        return Prize.of(match(lotto), isBonusHit(lotto));
    }

    private int match(Lotto lotto) {
        return lotto.match(winningLotto);
    }

    private boolean isBonusHit(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }
}
