package com.codesquad.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoGenerator implements LottoGenerator {
    private final Shuffler shuffler;
    private final List<Integer> numbers;

    public DefaultLottoGenerator(final Shuffler shuffler) {
        this.numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        this.shuffler = shuffler;
    }

    @Override
    public LottoNumber generate() {
        shuffler.shuffle(numbers);
        final List<Integer> lottoNumbers = numbers.stream()
                .limit(LottoNumber.NUMBER_SIZE)
                .collect(Collectors.toList());
        return new LottoNumber(lottoNumbers);
    }
}
