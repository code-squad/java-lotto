package com.codesquad.lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    @Before
    public void setUp() throws Exception {
        this.lottoNumber = lottoNumber = new LottoNumber(Arrays.asList(1, 10, 40, 33, 17, 45));
    }

    @Test
    public void 조회() {
        final List<Integer> numbers = lottoNumber.getNumbers();
        assertThat(numbers).contains(1, 10, 40, 33, 17, 45);
    }

    @Test
    public void 다른숫자조회() {
        final LottoNumber otherLottoNumber = new LottoNumber(Arrays.asList(3, 11, 40, 32, 28, 1));
        final List<Integer> numbers = otherLottoNumber.getNumbers();
        assertThat(numbers).contains(3, 11, 40, 32, 28, 1);
    }

    @Test
    public void 정렬된조회() {
        final List<Integer> numbers = this.lottoNumber.getNumbers();
        assertThat(numbers).containsExactly(1, 10, 17, 33, 40, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자_개수_부족() {
        final List<Integer> notEnoughNumbers = Arrays.asList(1, 2, 3, 4, 5);
        new LottoNumber(notEnoughNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자_개수_많음() {
        final List<Integer> overFlowNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        new LottoNumber(overFlowNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최소값보다_작은숫자포함() {
        final List<Integer> includeLessNumbers = Arrays.asList(-5, -1, 2, 3, 4, 5);
        new LottoNumber(includeLessNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최대값보다_큰숫자포함() {
        final List<Integer> includeGreatNumbers = Arrays.asList(42, 43, 44, 45, 46, 50);
        new LottoNumber(includeGreatNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Null생성() {
        new LottoNumber(null);
    }

    @Test
    public void 일치하는숫자개수_3() {
        final LottoNumber winNumber = new LottoNumber(Arrays.asList(1, 20, 5, 45, 17, 45));
        final long count = lottoNumber.getMatchedCount(winNumber);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void 일치하는숫자개수_6() {
        final LottoNumber winNumber = new LottoNumber(Arrays.asList(17, 45, 1, 10, 40, 33));
        final long count = lottoNumber.getMatchedCount(winNumber);
        assertThat(count).isEqualTo(6);
    }
}
