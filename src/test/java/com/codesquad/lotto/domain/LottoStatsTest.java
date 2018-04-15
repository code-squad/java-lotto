package com.codesquad.lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatsTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_Null로_생성() {
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        new LottoStats(null, lotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨로또_Null로_생성() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        new LottoStats(lotteries, null);
    }

    @Test
    public void 번호6개일치_1개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int count = stats.getWiningCount(WinType.SIX);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 번호6개일치_2개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int count = stats.getWiningCount(WinType.SIX);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void 번호5개일치_0개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int count = stats.getWiningCount(WinType.FIVE);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 번호6개일치_0개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final Lotto lotto = Lotto.of(7, 8, 9, 10, 11, 12);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int count = stats.getWiningCount(WinType.SIX);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 번호5개일치_1개() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 6, 10),
                Lotto.of(1, 2, 3, 4, 5, 10)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 40);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int count = stats.getWiningCount(WinType.FIVE);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 번호3개일치_1개_수익율_400() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 10, 11, 12);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int rate = stats.getProfitRate();
        assertThat(rate).isEqualTo(400);
    }

    @Test
    public void 번호3개일치_1개_수익율_0() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(20, 21, 22, 23, 24, 25),
                Lotto.of(20, 21, 22, 23, 24, 25),
                Lotto.of(20, 21, 22, 23, 24, 25),
                Lotto.of(20, 21, 22, 23, 24, 25)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 10, 11, 12);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int rate = stats.getProfitRate();
        assertThat(rate).isEqualTo(0);
    }

    @Test
    public void 번호개일치_4개_수익율_900() {
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15),
                Lotto.of(10, 11, 12, 13, 14, 15)
        );
        final Lotto lotto = Lotto.of(1, 2, 3, 4, 8, 9);
        final LottoStats stats = new LottoStats(lotteries, lotto);

        final int rate = stats.getProfitRate();
        assertThat(rate).isEqualTo(900);
    }
}
