package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbersCheck(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public int checkTheWinningNumbers(Lotto lotto) {
        List<Integer> checkNumbers = lotto.numbers;
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(checkNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void numbersCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
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
