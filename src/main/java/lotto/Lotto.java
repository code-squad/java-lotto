package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return this.numbers;
    }

    int matcherNumber(Lotto winningLotto) {
        int matchCount = 0;
        for (Integer number : this.numbers) {
            if (isContains(winningLotto, number))
                matchCount++;
        }
        return matchCount;
    }

    private boolean isContains(Lotto winningLotto, Integer number) {
        return winningLotto.getNumbers().contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
