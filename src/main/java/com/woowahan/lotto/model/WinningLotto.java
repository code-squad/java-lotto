package com.woowahan.lotto.model;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNo bonusNumber;

    public WinningLotto(Set<LottoNo> winningLotto, LottoNo bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public Set<LottoNo> getWinningLotto() {
        return winningLotto.getLotto();
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }

    public PriceInfo match(Lotto lotto) {
        // @TODO
        return null;
    }
}
