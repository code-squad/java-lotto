package lottogame.domain;

import lottogame.vo.LottoNumber;

public class WinnningLotto {
    final Lotto winningLotto;
    final LottoNumber bonusNumber;

    private WinnningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨번호와 달라야 합니다.");
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinnningLotto of(Lotto winningLottolotto, int bonus) {
        return new WinnningLotto(winningLottolotto, LottoNumber.Of(bonus));
    }

    public static WinnningLotto of(String winningLotto, String bonus) {
        return new WinnningLotto(
                Lotto.ofText(winningLotto),
                LottoNumber.Of(bonus));
    }

}
