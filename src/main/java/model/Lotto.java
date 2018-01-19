package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {
    private static final int SIZE = 6;

    private List<LottoNumber> numbers;

    Lotto() {
        this.numbers = generate();
    }

    Lotto(String[] numbers) throws IllegalArgumentException {
        if(new HashSet<>(Arrays.asList(numbers)).size() != Lotto.SIZE)
            throw new IllegalArgumentException(String.format("Expected: %d distinct numbers.", Lotto.SIZE));

        this.numbers = new ArrayList<>(
                Stream.of(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private List<LottoNumber> generate() {
        List<LottoNumber> numbers = IntStream.range(1, LottoNumber.BOUND)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        numbers = numbers.subList(0, Lotto.SIZE);
        Collections.sort(numbers);

        return numbers;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public String toString() {
        return "[" +
                numbers.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "]";
    }

    public int getMatchCount(Lotto target) {
        int matchCount = 0;
        for (LottoNumber num : this.numbers) {
            if (target.contains(num)) matchCount++;
        }
        return matchCount;
    }
}