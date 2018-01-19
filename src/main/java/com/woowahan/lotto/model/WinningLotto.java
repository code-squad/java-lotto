package com.woowahan.lotto.model;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNo bonusNumber;

    public WinningLotto(String winningLotto, LottoNo bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public Set<LottoNo> getWinningLotto() {
        return winningLotto.getLotto();
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }

    public int checkKeyCode(Lotto lotto) {
        int count = 0;

        for (LottoNo luck : winningLotto.getLotto()) {
            count += getCount(lotto, luck);
        }

        if (count == 5 && checkBonusNumber(lotto)) {
            count = 7;
        }

        return count;
    }

    private int getCount(Lotto lotto, LottoNo luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public PriceInfo match(Lotto lotto) {
        int keyCode = checkKeyCode(lotto);
        PriceInfo key = PriceInfo.getValueByWinningCondition(keyCode);
        return key;
    }
}
