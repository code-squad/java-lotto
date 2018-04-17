package com.codesquad.lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultTest {

    private Money payment;

    @Before
    public void setUp() throws Exception {
        payment = new Money(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 맵Null() {
        new LottoGameResult(null, payment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구매금액Null() {
        new LottoGameResult(createHashMap(0, 0, 0, 0), null);
    }

    @Test
    public void 번호6개일치_1개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 1);
        final LottoGameResult stats = new LottoGameResult(map, payment);

        final int count = stats.getWiningCount(WinType.SIX);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 번호6개일치_2개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 2);
        final LottoGameResult stats = new LottoGameResult(map, payment);

        final int count = stats.getWiningCount(WinType.SIX);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void 번호5개일치_0개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 0);
        final LottoGameResult stats = new LottoGameResult(map, payment);

        final int count = stats.getWiningCount(WinType.FIVE);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 번호6개일치_0개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 0);
        final LottoGameResult stats = new LottoGameResult(map, payment);

        final int count = stats.getWiningCount(WinType.SIX);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 번호5개일치_1개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 1, 0);
        final LottoGameResult stats = new LottoGameResult(map, payment);

        final int count = stats.getWiningCount(WinType.FIVE);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 번호3개일치_1개_1장_수익율_400() {
        final Map<WinType, Long> map = createHashMap(1, 0, 0, 0);
        final LottoGameResult stats = new LottoGameResult(map, new Money(1000));

        final int rate = stats.getProfitRate();
        assertThat(rate).isEqualTo(400);
    }

    @Test
    public void 번호3개일치_1개_수익율_0() {
        final Map<WinType, Long> map = createHashMap(1, 0, 0, 0);
        final LottoGameResult stats = new LottoGameResult(map, new Money(5000));

        final int rate = stats.getProfitRate();
        assertThat(rate).isEqualTo(0);
    }

    @Test
    public void 번호개일치_4개_수익율_900() {
        final Map<WinType, Long> map = createHashMap(0, 1, 0, 0);
        final LottoGameResult stats = new LottoGameResult(map, new Money(5000));

        final int rate = stats.getProfitRate();
        assertThat(rate).isEqualTo(900);
    }

    private Map<WinType, Long> createHashMap(final long three, final long four, final long five, final long six) {
        final Map<WinType, Long> map = new HashMap<>();
        if (three > 0) {
            map.put(WinType.THREE, three);
        }

        if (four > 0) {
            map.put(WinType.FOUR, four);
        }

        if (five > 0) {
            map.put(WinType.FIVE, five);
        }

        if (six > 0) {
            map.put(WinType.SIX, six);
        }

        return map;
    }
}
