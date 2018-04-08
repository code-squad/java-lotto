package lotto.domain;

import java.util.List;

/**
 * @author sangsik.kim
 */
public class Lotto {
    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this(AutoSelector.generate());
    }

    public Integer compareWithWinningNumbers(List<Integer> numbers) {
        return new Long(numbers
                .stream()
                .filter(integer -> this.numbers.contains(integer))
                .count())
                .intValue();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
