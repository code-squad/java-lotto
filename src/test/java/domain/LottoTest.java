package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoTest {

    @Test
    public void 중복값검사_true() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(Lotto.hasDuplication(numbers), is(true));
    }

    @Test
    public void 중복값검사_false() {
        List<Integer> numbers = Arrays.asList(1, 1, 3, 4, 5, 6);
        assertThat(Lotto.hasDuplication(numbers), is(false));
    }

    @Test
    public void 사이즈검사_true() {
        List<Integer> numbers = Arrays.asList(1, 1, 3, 4, 5, 6);
        assertThat(Lotto.isValidSize(numbers), is(true));
    }

    @Test
    public void 사이즈검사_false() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 5, 6);
        assertThat(Lotto.isValidSize(numbers), is(false));
    }

    @Test
    public void CountMatch() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ball bonusBall = Ball.of(8);
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusBall);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        Lotto lotto = Lotto.of(numbers);
        assertThat(lotto.countMatch(winningLotto), is(3));
    }
}
