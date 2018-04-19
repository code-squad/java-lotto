package com.codesquad.lotto.application;

import com.codesquad.lotto.domain.*;

import java.util.List;
import java.util.Objects;

public class LottoGame {
    private final Money payment;
    private final LottoBundle bundle;

    public LottoGame(final int amount, final Shuffler shuffler) {
        payment = new Money(amount);
        final LottoMachine machine = prepareLottoMachine(shuffler);
        bundle = machine.buy(payment);
    }

    private LottoMachine prepareLottoMachine(final Shuffler shuffler) {
        return new LottoMachine(new DefaultLottoNumberGenerator(shuffler));
    }

    public LottoGameResult play(final List<String> winningNumber) {
        final Lotto winningLotto = Lotto.fromComma(winningNumber.get(0));
        final WinningMatchResult matchResult = bundle.match(winningLotto);
        return new LottoGameResult(matchResult, payment);
    }

    public LottoBundle getBundle() {
        return this.bundle;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(payment, lottoGame.payment) &&
                Objects.equals(bundle, lottoGame.bundle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(payment, bundle);
    }
}
