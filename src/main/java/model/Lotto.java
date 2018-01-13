package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        numbers = sortNumbers(cutNumberSix(makeNumbers()));
    }

    private List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> numbers.add(i));
        return numbers;
    }

    private List<Integer> cutNumberSix(List<Integer> numbers) {
        List<Integer> cutNumbers = new ArrayList<>();
        Collections.shuffle(numbers);
        IntStream.range(0, 6).forEach(i -> cutNumbers.add(numbers.get(i)));
        return cutNumbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
