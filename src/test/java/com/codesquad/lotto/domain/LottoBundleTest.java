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

        final LottoStats stats = lottoBundle.match(Lotto.of(1, 2, 3, 4, 5, 6));

        final Map<WinType, Integer> map = new HashMap<>();
        map.put(WinType.THREE, 0);
        map.put(WinType.FOUR, 0);
        map.put(WinType.FIVE, 0);
        map.put(WinType.SIX, 1);
        assertThat(stats).isEqualTo(new LottoStats(map, new Money(1000)));
    }

    @Test
    public void 번호6개일치_2개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final LottoStats stats = lottoBundle.match(Lotto.of(1, 2, 3, 4, 5, 6));

        final Map<WinType, Integer> map = new HashMap<>();
        map.put(WinType.THREE, 0);
        map.put(WinType.FOUR, 0);
        map.put(WinType.FIVE, 0);
        map.put(WinType.SIX, 2);
        assertThat(stats).isEqualTo(new LottoStats(map, new Money(2000)));
    }

    @Test
    public void 번호일치_0개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final LottoStats stats = lottoBundle.match(Lotto.of(11, 12, 13, 14, 15, 16));

        final Map<WinType, Integer> map = new HashMap<>();
        map.put(WinType.THREE, 0);
        map.put(WinType.FOUR, 0);
        map.put(WinType.FIVE, 0);
        map.put(WinType.SIX, 0);
        assertThat(stats).isEqualTo(new LottoStats(map, new Money(3000)));
    }

    @Test
    public void 번호3개일치_1개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final LottoStats stats = lottoBundle.match(Lotto.of(1, 2, 3, 7, 8, 9));

        final Map<WinType, Integer> map = new HashMap<>();
        map.put(WinType.THREE, 1);
        map.put(WinType.FOUR, 0);
        map.put(WinType.FIVE, 0);
        map.put(WinType.SIX, 0);
        assertThat(stats).isEqualTo(new LottoStats(map, new Money(1000)));
    }

    @Test
    public void 번호3개일치_2개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final LottoBundle lottoBundle = new LottoBundle(lotteries);

        final LottoStats stats = lottoBundle.match(Lotto.of(1, 2, 3, 7, 8, 9));

        final Map<WinType, Integer> map = new HashMap<>();
        map.put(WinType.THREE, 2);
        map.put(WinType.FOUR, 0);
        map.put(WinType.FIVE, 0);
        map.put(WinType.SIX, 0);
        assertThat(stats).isEqualTo(new LottoStats(map, new Money(2000)));
    }
}
