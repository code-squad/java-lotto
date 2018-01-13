package model;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        numbersCheck(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public int checkTheWinningNumbers(List<Integer> numbers) {
        numbersCheck(numbers);
        sortNumbers(numbers);

        int count = 0;
        boolean done = true;
        int i = 0;
        int j = 0;
        while (done) {
            int number = this.numbers.get(i);
            int checkNumber = numbers.get(j);
            if (number == checkNumber) {
                count++;
                i++;
                j++;
            }
            if (number > checkNumber) {
                j++;
            }
            if (number < checkNumber) {
                i++;
            }
            if (i >= 6 || j >= 6) {
                done = false;
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
        for (int number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
