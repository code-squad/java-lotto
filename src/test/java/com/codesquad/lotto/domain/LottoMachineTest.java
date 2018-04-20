package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void 번호생성기_Null() {
        new LottoMachine(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구매금액_Null() {
        final LottoMachine machine = new LottoMachine(() -> Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
        machine.buy(null);
    }

    @Test
    public void 구매_5000원() {
        final LottoMachine machine = new LottoMachine(() -> Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
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
        final LottoMachine machine = new LottoMachine(() -> Stream.of(10, 11, 12, 13, 14, 15)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
        final LottoBundle bundle = machine.buy(new Money(3000));
        final LottoBundle expected = new LottoBundle(Arrays.asList(
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15)
        ));
        assertThat(bundle).isEqualTo(expected);
    }
}
