package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto {
    private static final int SIZE = 6;

    private List<LottoNumber> numbers;

    UserLotto() {
        this.numbers = generate();
    }

    UserLotto(List<Integer> numbers) throws IllegalArgumentException {
        if(new HashSet<>(numbers).size() != UserLotto.SIZE)
            throw new IllegalArgumentException(String.format("Expected: %d distinct numbers.", UserLotto.SIZE));

        this.numbers = new ArrayList<>(
                numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()));
    }

    private List<LottoNumber> generate() {
        List<LottoNumber> numbers = IntStream.range(1, LottoNumber.BOUND)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        numbers = numbers.subList(0, UserLotto.SIZE);
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
