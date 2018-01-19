package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto {
    private static final int BOUND = 46;
    private static final int SIZE = 6;

    private List<LottoNumber> numbers;

    UserLotto() {
        this.numbers = generate();
    }

    UserLotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(
                numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()));
    }

    private List<LottoNumber> generate() {
        List<LottoNumber> numbers = IntStream.range(1, this.BOUND)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        numbers = numbers.subList(0, this.SIZE);
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
}
