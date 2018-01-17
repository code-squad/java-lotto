package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers;

    private Lotto(LottoNumberGenerator lottoNumberGenerator) {
        numbers = lottoNumberGenerator.generate();
    }

    public static Lotto generate(LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(lottoNumberGenerator);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasBonusBall(int bonusBall) {
        return numbers.contains(bonusBall);
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
