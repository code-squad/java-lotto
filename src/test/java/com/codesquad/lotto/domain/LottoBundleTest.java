package com.codesquad.lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @Test
    public void 로또번들_생성() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(2, 3, 4, 5, 6, 7)
        );
        new LottoBundle(lotteries);
    }

    @Test
    public void 번호6개일치_1개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final WinningMatchResult result = lottoBundle.match(WinningLotto.fromComma("1, 2, 3, 4, 5, 6", "7"));

        final Map<WinType, Long> map = new HashMap<>();
        map.put(WinType.SIX, 1L);
        assertThat(result).isEqualTo(new WinningMatchResult(map));
    }

    @Test
    public void 번호6개일치_2개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final WinningMatchResult result = lottoBundle.match(WinningLotto.fromComma("1, 2, 3, 4, 5, 6", "7"));

        final Map<WinType, Long> map = new HashMap<>();
        map.put(WinType.SIX, 2L);
        assertThat(result).isEqualTo(new WinningMatchResult(map));
    }

    @Test
    public void 번호일치_0개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final WinningMatchResult result = lottoBundle.match(WinningLotto.fromComma("11, 12, 13, 14, 15, 16", "17"));

        final Map<WinType, Long> map = new HashMap<>();
        assertThat(result).isEqualTo(new WinningMatchResult(map));
    }

    @Test
    public void 번호3개일치_1개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final WinningMatchResult result = lottoBundle.match(WinningLotto.fromComma("1, 2, 3, 7, 8, 9", "10"));

        final Map<WinType, Long> map = new HashMap<>();
        map.put(WinType.THREE, 1L);
        assertThat(result).isEqualTo(new WinningMatchResult(map));
    }

    @Test
    public void 번호3개일치_2개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final WinningMatchResult result = lottoBundle.match(WinningLotto.fromComma("1, 2, 3, 7, 8, 9", "10"));

        final Map<WinType, Long> map = new HashMap<>();
        map.put(WinType.THREE, 2L);
        assertThat(result).isEqualTo(new WinningMatchResult(map));
    }
}
