package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoNumberGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 셔플_Null() {
        new DefaultLottoNumberGenerator(null);
    }

    @Test
    public void 번호생성_2to7() {
        final DefaultLottoNumberGenerator generator = new DefaultLottoNumberGenerator(numbers -> {
            numbers.clear();
            numbers.addAll(Stream.of(2, 3, 4, 5, 6, 7)
                    .map(LottoNumber::of)
                    .collect(Collectors.toList()));
        });
        final List<LottoNumber> numbers = generator.generate();
        assertThat(numbers).isEqualTo(Stream.of(2, 3, 4, 5, 6, 7)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    @Test
    public void 번호생성_5to10() {
        final DefaultLottoNumberGenerator generator = new DefaultLottoNumberGenerator(numbers -> {
            numbers.clear();
            numbers.addAll(Stream.of(5, 6, 7, 8, 9, 10)
                    .map(LottoNumber::of)
                    .collect(Collectors.toList()));
        });
        final List<LottoNumber> numbers = generator.generate();
        assertThat(numbers).isEqualTo(Stream.of(5, 6, 7, 8, 9, 10)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    @Test
    public void 숫자목록_45개중_번호생성() {
        final List<Integer> fullNumbers = IntStream.of(40, 41, 42, 43, 44, 45)
                .boxed()
                .collect(Collectors.toList());
        fullNumbers.addAll(IntStream.rangeClosed(1, 39)
                .boxed()
                .collect(Collectors.toList()));
        final List<LottoNumber> lottoNumbers = fullNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        final DefaultLottoNumberGenerator generator = new DefaultLottoNumberGenerator(numbers -> {
            numbers.clear();
            numbers.addAll(lottoNumbers);
        });
        final List<LottoNumber> numbers = generator.generate();
        assertThat(numbers).isEqualTo(Stream.of(40, 41, 42, 43, 44, 45)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }
}
