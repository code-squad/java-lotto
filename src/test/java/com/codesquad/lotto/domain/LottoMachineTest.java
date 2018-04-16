package com.codesquad.lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void 번호생성기_Null() {
        new LottoMachine(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구매금액_Null() {
        final LottoMachine machine = new LottoMachine(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        machine.buy(null);
    }

    @Test
    public void 구매_5000원() {
        final LottoMachine machine = new LottoMachine(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoBundle bundle = machine.buy(new Money(5000));
        final LottoBundle expected = new LottoBundle(Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        ));
        assertThat(bundle).isEqualTo(expected);
    }

    @Test
    public void 구매_3000원() {
        final LottoMachine machine = new LottoMachine(() -> Arrays.asList(10, 11, 12, 13, 14, 15));
        final LottoBundle bundle = machine.buy(new Money(3000));
        final LottoBundle expected = new LottoBundle(Arrays.asList(
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15)
        ));
        assertThat(bundle).isEqualTo(expected);
    }
}
