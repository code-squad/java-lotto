package com.codesquad.lotto.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningMatchResultTest {
    @Test(expected = IllegalArgumentException.class)
    public void 등수별_당첨수량_null() {
        new WinningMatchResult(null);
    }

    @Test
    public void 번호6개일치_1개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 1);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final int count = matchResult.getCountByWinType(WinType.SIX);

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 번호6개일치_1개당첨_상금() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 1);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final Money prize = matchResult.getTotalPrize();

        assertThat(prize).isEqualTo(new Money(2_000_000_000));
    }

    @Test
    public void 번호6개일치_2개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 2);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final int count = matchResult.getCountByWinType(WinType.SIX);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void 번호3개일치_2개당첨_상금() {
        final Map<WinType, Long> map = createHashMap(2, 0, 0, 0);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final Money prize = matchResult.getTotalPrize();

        assertThat(prize).isEqualTo(new Money(10_000));
    }


    @Test
    public void 번호5개일치_0개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 0);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final int count = matchResult.getCountByWinType(WinType.FIVE);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 번호5개일치_1개당첨_상금() {
        final Map<WinType, Long> map = createHashMap(0, 0, 1, 0);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final Money prize = matchResult.getTotalPrize();

        assertThat(prize).isEqualTo(new Money(1_500_000));
    }

    @Test
    public void 번호6개일치_0개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 0, 0);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final int count = matchResult.getCountByWinType(WinType.SIX);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 번호5개일치_1개() {
        final Map<WinType, Long> map = createHashMap(0, 0, 1, 0);
        final WinningMatchResult matchResult = new WinningMatchResult(map);

        final int count = matchResult.getCountByWinType(WinType.FIVE);

        assertThat(count).isEqualTo(1);
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
