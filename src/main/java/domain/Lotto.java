package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int getNumOfMatched(List<Integer> winningNumbers) {
        return (int)numbers.stream().filter(winningNumbers::contains).count();
    }

    @Override
    public String toString(){
        return numbers.stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
