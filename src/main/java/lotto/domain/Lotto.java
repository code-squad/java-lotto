package lotto.domain;

import java.util.List;

import lotto.domain.lottogenerator.LottoNumberGenerator;

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

    public int getCorrectCount(List<Integer> winNumbers) {
        return (int) numbers.stream()
                .filter(winNumbers::contains)
                .count();
    }
}
