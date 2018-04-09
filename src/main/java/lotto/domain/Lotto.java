package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {

    static final int DEFAULT_PRICE = 1_000;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createNumbers();
    }

    public Lotto(List<String> numbers) {
        this.numbers = numbers
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }

    List<Integer> createNumbers() {
        List<Integer> numbers = IntStream
                .rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(toList());

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numbers);
    }
}
