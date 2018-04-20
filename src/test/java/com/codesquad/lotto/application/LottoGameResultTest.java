package com.codesquad.lotto.application;

import com.codesquad.lotto.domain.Money;
import com.codesquad.lotto.domain.WinType;
import com.codesquad.lotto.domain.WinningMatchResult;
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
    public void 매치결과_Null() {
        new LottoGameResult(null, payment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구매금액Null() {
        final WinningMatchResult result = new WinningMatchResult(createHashMap(0, 0, 0, 0));
        new LottoGameResult(result, null);
    }

    @Test
    public void 매치결과조회() {
        final Map<WinType, Long> map = createHashMap(1, 0, 0, 0);
        final WinningMatchResult matched = new WinningMatchResult(map);
        final LottoGameResult stats = new LottoGameResult(matched, new Money(1000));

        final WinningMatchResult matchResult = stats.getMatchResult();
        assertThat(matchResult).isEqualTo(matched);
    }

    @Test
    public void 번호3개일치_1개_1장_수익율_400() {
        final Map<WinType, Long> map = createHashMap(1, 0, 0, 0);
        final WinningMatchResult matched = new WinningMatchResult(map);
        final LottoGameResult stats = new LottoGameResult(matched, new Money(1000));

        final int rate = stats.calcProfitRate();
        assertThat(rate).isEqualTo(400);
    }

    @Test
    public void 번호3개일치_1개_수익율_0() {
        final Map<WinType, Long> map = createHashMap(1, 0, 0, 0);
        final WinningMatchResult matched = new WinningMatchResult(map);
        final LottoGameResult stats = new LottoGameResult(matched, new Money(5000));

        final int rate = stats.calcProfitRate();
        assertThat(rate).isEqualTo(0);
    }

    @Test
    public void 번호개일치_4개_수익율_900() {
        final Map<WinType, Long> map = createHashMap(0, 1, 0, 0);
        final WinningMatchResult result = new WinningMatchResult(map);
        final LottoGameResult stats = new LottoGameResult(result, new Money(5000));

        final int rate = stats.calcProfitRate();
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
