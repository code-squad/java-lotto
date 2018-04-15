package com.codesquad.lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 단가로_생성() {
        new LottoMachine(new Money(1000), () -> Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 단가_Null() {
        new LottoMachine(null, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 번호생성기_Null() {
        new LottoMachine(new Money(1000), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구매금액_Null() {
        final LottoMachine machine = new LottoMachine(new Money(1000), () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        machine.buy(null);
    }

    @Test
    public void 구매_5000원() {
        final LottoMachine machine = new LottoMachine(new Money(1000), () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        final List<Lotto> lotteries = machine.buy(new Money(5000));
        assertThat(lotteries.size()).isEqualTo(5);
    }

    @Test
    public void 구매_3000원() {
        final LottoMachine machine = new LottoMachine(new Money(1500), () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        final List<Lotto> lotteries = machine.buy(new Money(3000));
        assertThat(lotteries.size()).isEqualTo(2);
    }

    @Test
    public void 잔돈무시() {
        final LottoMachine machine = new LottoMachine(new Money(1200), () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        final List<Lotto> lotteries = machine.buy(new Money(3000));
        assertThat(lotteries.size()).isEqualTo(2);
    }
}
