package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(String lastWinningNumbers, int bonusNumber) {
        this.winningLotto = Lotto.generateManualLotto(lastWinningNumbers);

        //메세지를 보내서 일을 하게 해라...ㅠㅠㅠㅠ
        //if(this.winningLotto.getLottoNumbers().contains(bonusNumber)) { 기존의사고방식
        //if(winningLotto.contains(bonusNumber)) { 객체지향적
        if(winningLotto.contains(bonusNumber)) {
            throw new DuplicateLottoNumberException("중복 된 보너스볼입니다.");
        }

        if(bonusNumber < 1 || bonusNumber > 45) {
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

    boolean isBonusHit(Lotto lotto) {
        return (lotto.getCountOfHit(this.winningLotto) == Prize.SECOND.getCountOfHit())
                && lotto.getLottoNumbers().contains(bonusNumber);
    }
}