package lotto.domain;

import lotto.util.LottoRecorder;

import java.util.Objects;

public class WinningLotto extends Lotto {
    private Lotto jackpot;
    private LottoNumber luckyNumber;

    public WinningLotto(Lotto jackpot, LottoNumber luckyNumber) {
        this.jackpot = jackpot;
        this.luckyNumber = luckyNumber;
    }

    public LottoNumber getLuckyNumber() {
        return luckyNumber;
    }

    public int containCount(Lotto lotto) {
        return this.jackpot.containCount(lotto);
    }

    public LottoRecorder match(Lotteries lottoList, LottoNumber luckyNumber) {
        Objects.requireNonNull(lottoList);
        return new LottoRecorder(new WinningLotto(this, luckyNumber), lottoList);
    }
}
