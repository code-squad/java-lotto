package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;

import static com.zingoworks.lotto.domain.Lotto.MAX_RANGE;
import static com.zingoworks.lotto.domain.Lotto.MIN_RANGE;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(String lastWinningNumbers, int bonusNumber) {
        this.winningLotto = Lotto.generateManualLotto(lastWinningNumbers);

        if(winningLotto.contains(bonusNumber)) {
            throw new DuplicateLottoNumberException("중복 된 보너스볼입니다.");
        }

        if(bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException("유효범위를 초과하였습니다.");
        }

        this.bonusNumber = bonusNumber;
    }

    Lotto getWinningLotto() {
        return winningLotto;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    Prize match(Lotto lotto) {
        for (Prize prize : Prize.values()) {
            if(prize.getCountOfHit() == lotto.getCountOfHit(winningLotto)
                    && prize.isBonusHit() == isBonusHit(lotto)) {
                return prize;
            }
        }
        return null;
    }

    private boolean isBonusHit(Lotto lotto) {
        return (lotto.getCountOfHit(winningLotto) == Prize.SECOND.getCountOfHit())
                && lotto.contains(bonusNumber);
    }
}