package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        numbersCheck();
        sortNumbers();
    }

    protected void numbersCheck() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortNumbers() {
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
