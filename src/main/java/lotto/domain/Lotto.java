package lotto.domain;

import lotto.domain.generator.CustomLottoNumberGenerator;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.RandomLottoNumberGenerator;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers;

    private Lotto(LottoNumberGenerator lottoNumberGenerator) {
        numbers = lottoNumberGenerator.generate();
    }

    public static Lotto newRandomLotto() {
        return new Lotto(new RandomLottoNumberGenerator());
    }

    public static Lotto newCustomLotto(List<Integer> customLottoNumbers) {
        return new Lotto(new CustomLottoNumberGenerator(customLottoNumbers));
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
