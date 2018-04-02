package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BallTest {

    @Test
    public void 유효값테스트_true() {
        assertThat(Ball.isValidBall(1), is(true));
        assertThat(Ball.isValidBall(45), is(true));
    }

    @Test
    public void 유효값테스트_false() {
        assertThat(Ball.isValidBall(0), is(false));
        assertThat(Ball.isValidBall(46), is(false));
    }

    @Test
    public void 볼포함여부검사_true() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ball ball = Ball.of(1);
        assertThat(ball.isContainedIn(numbers), is(true));
    }

    @Test
    public void 볼포함여부검사_false() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ball ball = Ball.of(7);
        assertThat(ball.isContainedIn(numbers), is(false));
    }
}
