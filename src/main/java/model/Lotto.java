package model;

import java.util.*;
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

    public Lotto(int bound, int size, List<Integer> numbers) {
        this.bound = bound;
        this.size = size;
        this.numbers = new ArrayList<>(numbers);
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

    public int compare(Lotto target) {
        int result = 0;
        for (Integer num : this.numbers) {
            if (target.getNumbers().contains(num)) result++;
        }
        return result;
    }
}
