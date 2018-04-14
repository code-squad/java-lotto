package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.Money;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 단가로_생성() {
        new LottoMachine(new Money(1000));
    }

    @Test
    public void 구매_5000원() {
        final LottoMachine machine = new LottoMachine(new Money(1000));
        final List<LottoNumber> lotteries = machine.buy(new Money(5000));
        assertThat(lotteries.size()).isEqualTo(5);
    }

    @Test
    public void 구매_3000원() {
        final LottoMachine machine = new LottoMachine(new Money(1500));
        final List<LottoNumber> lotteries = machine.buy(new Money(3000));
        assertThat(lotteries.size()).isEqualTo(2);
    }

    @Test
    public void 잔돈무시() {
        final LottoMachine machine = new LottoMachine(new Money(1200));
        final List<LottoNumber> lotteries = machine.buy(new Money(3000));
        assertThat(lotteries.size()).isEqualTo(2);
    }
}
