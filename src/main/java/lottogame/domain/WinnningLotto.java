package lottogame.domain;

import java.util.List;

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

    public static WinnningLotto of(List<Integer> winningLottoNum, int input) {
        return new WinnningLotto(new Lotto(winningLottoNum), new LottoNumber(input));
    }

}
