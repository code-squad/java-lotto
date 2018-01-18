package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int BOUND = 46;
    private static final int SIZE = 6;

    private List<Integer> numbers;

    public Lotto() {
        this.numbers = generate();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private List<Integer> generate() {
        List<Integer> numbers = IntStream.range(1, this.BOUND)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        numbers = numbers.subList(0, this.SIZE);
        Collections.sort(numbers);

        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int compare(Lotto target) {
        int result = 0;
        for (Integer num : this.numbers) {
            if (target.getNumbers().contains(num)) result++;
        }
        return result;
    }
}
