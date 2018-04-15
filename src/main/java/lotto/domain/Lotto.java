package lotto.domain;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Collection<Integer> getNumbers() {
        return Collections.unmodifiableCollection(numbers);
    }

    public Rank match(WinningLotto winningLotto) {
        return Rank.valueOf(Math.toIntExact(numbers.stream()
                .filter(number -> winningLotto.contains(number))
                .count()), winningLotto.matchBonusNumber(numbers));
    }

    public boolean contains(int lottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers.toString() +
                '}';
    }
}
