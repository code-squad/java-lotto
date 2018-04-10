package lotto.domain;

import java.util.List;

/**
 * @author sangsik.kim
 */
public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this(AutoSelector.generate());
    }

    public Rank getRank(Lotto winningLotto, Integer bonusNumber) {
        return Rank.valueOf(Math.toIntExact(this.numbers
                .stream()
                .filter(integer -> winningLotto.numbers.contains(integer))
                .count()), this.numbers.contains(bonusNumber));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
