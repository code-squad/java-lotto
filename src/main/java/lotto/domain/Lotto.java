package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public Collection<LottoNumber> getNumbers() {
        return Collections.unmodifiableCollection(numbers);
    }

    public Rank match(WinningLotto winningLotto) {
        return Rank.valueOf(Math.toIntExact(numbers.stream()
                .filter(number -> winningLotto.contains(number))
                .count()), winningLotto.matchBonusNumber(numbers));
    }

    public boolean contains(LottoNumber lottoNumber) {
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
