package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Number> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().map(Number::of).collect(Collectors.toList());
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int getNumOfMatched(Lotto winningLotto) {
        return (int)numbers.stream().filter(winningLotto.numbers::contains).count();
    }

    @Override
    public String toString(){
        return numbers.stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
