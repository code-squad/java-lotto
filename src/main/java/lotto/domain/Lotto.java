package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private Set<LottoNumber> numbers;

    private Lotto(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("INVALID NUMBERS");
        }
        this.numbers = numbers;
    }

    public static Lotto of(int... numbers) {
        return new Lotto(Arrays
                .stream(numbers)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    public Rank match(WinningLotto winningLotto) {
        return Rank.valueOf(Math.toIntExact(this.numbers
                .stream()
                .filter(lottoNumber -> winningLotto.contains(lottoNumber))
                .count()), winningLotto.matchBonusNumber(this.numbers));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
