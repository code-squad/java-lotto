package lotto;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
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
