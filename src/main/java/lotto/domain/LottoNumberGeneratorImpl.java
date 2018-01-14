package lotto.domain;

import lotto.util.LottoUtils;

import java.util.Arrays;
import java.util.Random;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {
    private static Random random;

    public LottoNumberGeneratorImpl() {
        random = new Random();
    }

    @Override
    public int[] generate() {
        int[] numbers = new int[LottoUtils.LOTTO_MAX_COUNT];
        return Arrays.stream(numbers)
                .map(i -> random.nextInt(LottoUtils.LOTTO_MAX_NUMBER))
                .sorted()
                .toArray();
    }
}
