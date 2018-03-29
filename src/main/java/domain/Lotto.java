package domain;

import java.util.List;
import java.util.function.Function;

public class Lotto {

    List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumOfMatches(List<Integer> answer) {
        return (int)numbers.stream().filter(answer::contains).count();
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}
