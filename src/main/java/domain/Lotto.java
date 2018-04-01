package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private List<Ball> balls;

    public Lotto() {

    }

    Lotto(List<Integer> numbers) {
        if (!isValidNumbers(numbers)) {
            throw new IllegalArgumentException("올바른 값을 넣어주세요.");
        }
        this.balls = numbers.stream().map(Ball::of).collect(Collectors.toList());
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    static boolean isValidNumbers(List<Integer> numbers) {
        return isValidSize(numbers) && hasDuplication(numbers);
    }

    static boolean hasDuplication(List<Integer> numbers) {
        return numbers.stream().distinct().count() == (long) numbers.size();
    }

    static boolean isValidSize(List<Integer> numbers) {
        final int VALID_NUMBER_LENGTH = 6;
        return numbers.size() == VALID_NUMBER_LENGTH;
    }

    int countMatch(Lotto winninglotto) {
        return (int) this.balls.stream().filter(winninglotto.balls::contains).count();
    }

    public Rank askRank(WinningLotto winninglotto) {
        return Rank.valueOf(countMatch(winninglotto), winninglotto.isBonus(balls));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(balls, lotto.balls);
    }

    @Override
    public int hashCode() {

        return Objects.hash(balls);
    }

    @Override
    public String toString(){
        return balls.toString();
    }
}
