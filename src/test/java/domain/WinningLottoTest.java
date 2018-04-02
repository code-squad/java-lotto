package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WinningLottoTest {

    @Test
    public void 보너스볼유효값검사_true() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(WinningLotto.isValidBonusBall(numbers, Ball.of(7)), is(true));
    }

    @Test
    public void 보너스볼유효값검사_false() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(WinningLotto.isValidBonusBall(numbers, Ball.of(6)), is(false));
    }

    @Test
    public void 보너스볼확인_true() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, Ball.of(7));
        List<Ball> ballsInTicket = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3), Ball.of(4), Ball.of(7), Ball.of(8));
        assertThat(winningLotto.isBonus(ballsInTicket), is(true));
    }

    @Test
    public void 보너스볼확인_false() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, Ball.of(7));
        List<Ball> ballsInTicket = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3), Ball.of(4), Ball.of(9), Ball.of(8));
        assertThat(winningLotto.isBonus(ballsInTicket), is(false));
    }
}
