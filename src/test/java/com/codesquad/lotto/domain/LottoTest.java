package com.codesquad.lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        this.lotto = lotto = new Lotto(Arrays.asList(1, 10, 40, 33, 17, 45));
    }

    @Test
    public void 조회() {
        final List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).contains(1, 10, 40, 33, 17, 45);
    }

    @Test
    public void 다른숫자조회() {
        final Lotto otherLotto = new Lotto(Arrays.asList(3, 11, 40, 32, 28, 1));
        final List<Integer> numbers = otherLotto.getNumbers();
        assertThat(numbers).contains(3, 11, 40, 32, 28, 1);
    }

    @Test
    public void 정렬된조회() {
        final List<Integer> numbers = this.lotto.getNumbers();
        assertThat(numbers).containsExactly(1, 10, 17, 33, 40, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자_개수_부족() {
        final List<Integer> notEnoughNumbers = Arrays.asList(1, 2, 3, 4, 5);
        new Lotto(notEnoughNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자_개수_많음() {
        final List<Integer> overFlowNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        new Lotto(overFlowNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최소값보다_작은숫자포함() {
        final List<Integer> includeLessNumbers = Arrays.asList(-5, -1, 2, 3, 4, 5);
        new Lotto(includeLessNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최대값보다_큰숫자포함() {
        final List<Integer> includeGreatNumbers = Arrays.asList(42, 43, 44, 45, 46, 50);
        new Lotto(includeGreatNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Null생성() {
        new Lotto(null);
    }

    @Test
    public void 일치하는숫자개수_3() {
        final Lotto winNumber = new Lotto(Arrays.asList(1, 20, 5, 45, 17, 45));
        final long count = lotto.getMatchedCount(winNumber);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void 일치하는숫자개수_6() {
        final Lotto winNumber = new Lotto(Arrays.asList(17, 45, 1, 10, 40, 33));
        final long count = lotto.getMatchedCount(winNumber);
        assertThat(count).isEqualTo(6);
    }

    @Test
    public void 일치하는숫자개수_0() {
        final Lotto winNumber = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        final long count = lotto.getMatchedCount(winNumber);
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void 포함확인_1() {
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    public void 포함확인_10() {
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    public void 포함확인_40() {
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    public void 포함확인_33() {
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    public void 포함확인_17() {
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    public void 포함확인_45() {
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    public void 미포함확인_2() {
        assertThat(lotto.contains(2)).isFalse();
    }

    @Test
    public void 미포함확인_45() {
        assertThat(lotto.contains(44)).isFalse();
    }

    @Test
    public void toString테스트() {
        assertThat(lotto.toString()).isEqualTo("[1, 10, 17, 33, 40, 45]");
    }
}
