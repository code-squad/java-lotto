package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {

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
                .rangeClosed(LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER)
                .boxed()
                .collect(toList());

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    public int size() {
        return Objects.isNull(numbers) ? 0 : numbers.size();
    }

    public int countOfMatch(Lotto lotto) {
        return (int) lotto
                .numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean contains(String number) {
        return numbers.contains(Integer.parseInt(number));
    }

    private void valid(List<String> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != LottoRule.NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
