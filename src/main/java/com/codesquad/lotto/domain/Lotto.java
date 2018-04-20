package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("6자리 숫자목록이 필요합니다.");
        }

        if (!isCorrectSize(numbers)) {
            throw new IllegalArgumentException("6자리 숫자가 입력되어야 합니다.");
        }

        this.numbers = numbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::getValue))
                .collect(Collectors.toList());
    }

    public static Lotto fromLottoNumbers(final List<LottoNumber> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        return new Lotto(numbers);
    }

    public static Lotto fromList(final List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        final List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::of)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public static Lotto fromComma(final String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final String[] split = numbers.split(", ");
        return new Lotto(Arrays.stream(split)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public static Lotto of(final int... numbers) {
        return new Lotto(Arrays.stream(numbers)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private boolean isCorrectSize(final List<LottoNumber> numbers) {
        return numbers.size() == NUMBER_SIZE;
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public int matchedCount(final Lotto winLotto) {
        return (int) numbers.stream()
                .filter(winLotto::contains)
                .count();
    }

    public boolean contains(final LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numbers);
    }
}
