package lotto.domain;

import lotto.util.LottoRecorder;

import java.util.Objects;

public class WinningLotto extends Lotto {
    private LottoNumber luckyNumber;

    public WinningLotto(Lotto jackpot, LottoNumber luckyNumber) {
        super(jackpot);
        this.luckyNumber = luckyNumber;
    }

    public LottoNumber getLuckyNumber() {
        return luckyNumber;
    }

    public int containCount(Lotto lotto) {
        return super.containCount(lotto);
    }

    public LottoRecorder match(Lotteries lottoList, LottoNumber luckyNumber) {
        Objects.requireNonNull(lottoList);
        return new LottoRecorder(this, lottoList);
    }
}
