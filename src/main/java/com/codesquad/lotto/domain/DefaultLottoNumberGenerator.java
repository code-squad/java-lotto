package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoNumberGenerator implements LottoNumberGenerator {
    private final Shuffler shuffler;
    private final List<LottoNumber> numbers;

    public DefaultLottoNumberGenerator(final Shuffler shuffler) {
        if (shuffler == null) {
            throw new IllegalArgumentException("셔플이 필요합니다.");
        }

        this.numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        this.shuffler = shuffler;
    }

    @Override
    public List<LottoNumber> generate() {
        shuffler.shuffle(numbers);
        return numbers.stream()
                .limit(Lotto.NUMBER_SIZE)
                .collect(Collectors.toList());
    }
}
