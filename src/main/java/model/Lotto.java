package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> numbers;
    private final int bound;
    private final int size;

    public Lotto(int bound, int size) {
        this.bound = bound;
        this.size = size;

        this.numbers = generate();
    }

    public List<Integer> generate() {
        List<Integer> numbers = IntStream.range(1, this.bound)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        numbers = numbers.subList(0, this.size);
        Collections.sort(numbers);

        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
