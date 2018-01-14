package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private int[] numbers;

    private Lotto(LottoNumberGenerator lottoNumberGenerator) {
        numbers = lottoNumberGenerator.generate();
    }

    public static Lotto generate(LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(lottoNumberGenerator);
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getCorrectCount(List<Integer> winNumbers) {
        return (int) Arrays.stream(numbers)
                .boxed()
                .filter(winNumbers::contains)
                .count();
    }
}
