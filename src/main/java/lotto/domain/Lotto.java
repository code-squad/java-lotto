package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;

import java.util.List;

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
}
