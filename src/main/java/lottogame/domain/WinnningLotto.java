package lottogame.domain;

public class WinnningLotto {
    final Lotto winningLotto;
    final LottoNumber bonusNumber;

    private WinnningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinnningLotto of(Lotto winningLottolotto, int bonus) {
        return new WinnningLotto(winningLottolotto, new LottoNumber(bonus));
    }

}
