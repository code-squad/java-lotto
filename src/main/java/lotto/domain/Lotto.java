package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public Rank match(WinningLotto winningLotto) {
        return Rank.valueOf(Math.toIntExact(this.numbers
                .stream()
                .filter(integer -> winningLotto.contains(integer))
                .count()), this.numbers.contains(winningLotto.getBonusNumber()));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
