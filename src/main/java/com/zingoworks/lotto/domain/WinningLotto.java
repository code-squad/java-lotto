package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(String lastWinningNumbers, int bonusNumber) {
        this.winningLotto = Lotto.generateManualLotto(lastWinningNumbers);

        if(this.winningLotto.getLottoNumbers().contains(bonusNumber)) {
            throw new DuplicateLottoNumberException("중복 된 보너스볼입니다.");
        }

        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("유효범위를 초과하였습니다.");
        }

        this.bonusNumber = bonusNumber;
    }

    //getter를 줄일 순 없나...? 여기랑 Lotto랑...?
    //WinningLotto 객체가 winningLotto라는 Lotto객체를 가지니까 자꾸 getLottoNumbers를 써야하는데... 굳이?
    Lotto getWinningLotto() {
        return winningLotto;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    boolean isBonusHit(Lotto lotto) {
        return (lotto.getCountOfHit(this.winningLotto) == Prize.SECOND.getCountOfHit())
                && lotto.getLottoNumbers().contains(bonusNumber);
    }
}
