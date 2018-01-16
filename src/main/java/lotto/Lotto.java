package lotto;

import model.RandomNumber;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto() {
        this.numbers = generateNumber();
    }

    public List<Integer> generateNumber() {
        return RandomNumber.shuffleNumber();
    }

    public Integer compare(List<Integer> result) {
        Integer hit = 0;

        for (Integer one : result) {
            if (numbers.contains(one)) {
                hit ++;
            }
        }

        return hit;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
