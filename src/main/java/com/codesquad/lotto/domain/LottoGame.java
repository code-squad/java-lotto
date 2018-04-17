package com.codesquad.lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoGame {
    private final LottoBundle bundle;

    public LottoGame(final int amount, final Shuffler shuffler) {
        final Money payment = new Money(amount);
        final LottoMachine machine = prepareLottoMachine(shuffler);
        bundle = machine.buy(payment);
    }

    private LottoMachine prepareLottoMachine(final Shuffler shuffler) {
        return new LottoMachine(new DefaultLottoNumberGenerator(shuffler));
    }

    public LottoGameResult play(final List<String> winningNumber) {
        final Lotto winningLotto = Lotto.fromComma(winningNumber.get(0));
        return bundle.match(winningLotto);
    }

    public String countMessage() {
        return String.format("%d개를 구매했습니다.", bundle.count());
    }

    public String lottoList() {
        final List<String> list = bundle.lotteriesString();
        return String.join("\r\n", list);
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
        return Objects.equals(bundle, lottoGame.bundle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bundle);
    }
}
