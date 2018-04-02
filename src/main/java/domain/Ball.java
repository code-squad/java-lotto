package domain;

import domain.exceptions.InvalidBallException;

import java.util.List;
import java.util.Objects;

public class Ball {

    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_INCLUSIVE = 45;
    private final int num;

    private Ball(int num) {
        if (!isValidBall(num)) {
            throw new InvalidBallException("입력값은 1-45사이 입니다.");
        }
        this.num = num;
    }

    static boolean isValidBall(int num) {
        return MIN_INCLUSIVE < num && num <= MAX_INCLUSIVE;
    }

    public static Ball of(int num) {
        return new Ball(num);
    }

    public boolean isContainedIn(List<Integer> numbers) {
        return numbers.contains(this.num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return num == ball.num;
    }

    @Override
    public int hashCode() {

        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}