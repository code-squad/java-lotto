package com.codesquad.lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoNumberGeneratorTest {

    @Test
    public void 번호생성_2to7() {
        final DefaultLottoNumberGenerator generator = new DefaultLottoNumberGenerator(numbers -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        });
        final List<Integer> numbers = generator.generate();
        assertThat(numbers).contains(2, 3, 4, 5, 6, 7);
    }

    @Test
    public void 번호생성_5to10() {
        final DefaultLottoNumberGenerator generator = new DefaultLottoNumberGenerator(numbers -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(5, 6, 7, 8, 9, 10));
        });
        final List<Integer> numbers = generator.generate();
        assertThat(numbers).contains(5, 6, 7, 8, 9, 10);
    }

    @Test
    public void 숫자목록_45개중_번호생성() {
        final List<Integer> partialNumbers = IntStream.rangeClosed(1, 39)
                .boxed()
                .collect(Collectors.toList());
        final DefaultLottoNumberGenerator generator = new DefaultLottoNumberGenerator(numbers -> {
            numbers.clear();
            numbers.addAll(Arrays.asList(40, 41, 42, 43, 44, 45));
            numbers.addAll(partialNumbers);
        });
        final List<Integer> numbers = generator.generate();
        assertThat(numbers).containsExactly(40, 41, 42, 43, 44, 45);
    }
}
