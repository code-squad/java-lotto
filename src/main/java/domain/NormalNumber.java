package domain;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class NormalNumber {
    private List<Integer> numbers;

    NormalNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calcMatchCount(NormalNumber winningNumbers) {
        int count = 0;
        List<Integer> winning = winningNumbers.numbers;
        for (Integer number : numbers) {
            if (winning.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public String unfoldNumbers() {
        Collections.sort(numbers);
        return numbers.stream().map(String::valueOf).collect(joining(", "));
    }
}
