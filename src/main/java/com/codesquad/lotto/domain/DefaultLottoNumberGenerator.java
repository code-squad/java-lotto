package com.codesquad.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoNumberGenerator implements LottoNumberGenerator {
    private final Shuffler shuffler;
    private final List<Integer> numbers;

    public DefaultLottoNumberGenerator(final Shuffler shuffler) {
        if (shuffler == null) {
            throw new IllegalArgumentException("셔플이 필요합니다.");
        }

        this.numbers = IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        this.shuffler = shuffler;
    }

    @Override
    public List<Integer> generate() {
        shuffler.shuffle(numbers);
        return numbers.stream()
                .limit(Lotto.NUMBER_SIZE)
                .collect(Collectors.toList());
    }
}
