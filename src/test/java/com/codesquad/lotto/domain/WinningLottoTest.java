package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void 생성() {
        WinningLotto.fromList(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList()), LottoNumber.of(7));
    }

    @Test
    public void 비교() {
        final WinningLotto winningLotto = WinningLotto.fromList(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList()), LottoNumber.of(7));

        assertThat(winningLotto).isEqualTo(WinningLotto.fromList(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)), LottoNumber.of(7)));
    }

    @Test
    public void 보너스볼_비교() {
        final WinningLotto winningLotto = WinningLotto.fromList(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList()), LottoNumber.of(7));

        assertThat(winningLotto).isNotEqualTo(WinningLotto.fromList(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)), LottoNumber.of(8)));
    }

    @Test
    public void 다른숫자비교() {
        final WinningLotto winningLotto = WinningLotto.fromList(Stream.of(3, 4, 5, 6, 7, 8)
                .map(LottoNumber::of)
                .collect(Collectors.toList()), LottoNumber.of(9));

        assertThat(winningLotto).isEqualTo(WinningLotto.fromList(Arrays.asList(
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7),
                LottoNumber.of(6),
                LottoNumber.of(8)), LottoNumber.of(9)));
    }
}
