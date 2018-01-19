package com.woowahan.lotto.model;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getLotto();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
