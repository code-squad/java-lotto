package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    static final int DEFAULT_PRICE = 1_000;
    static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createNumbers();
    }

    public Lotto(List<String> numbers) {
        valid(numbers);

        this.numbers = numbers
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers = IntStream
                .rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(toList());

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    public Rank match(Lotto lotto) {
        int matchCount = (int) lotto
                .numbers
                .stream()
                .filter(this.numbers::contains)
                .count();

        return Rank.getRank(matchCount);
    }

    public int size() {
        return Objects.isNull(numbers) ? 0 : numbers.size();
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

    private void valid(List<String> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

}
