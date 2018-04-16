package com.codesquad.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("6자리 숫자목록이 필요합니다.");
        }

        if (!isCorrectSize(numbers)) {
            throw new IllegalArgumentException("6자리 숫자가 입력되어야 합니다.");
        }

        if (isIncludeLessThanMin(numbers)) {
            throw new IllegalArgumentException(String.format("입력가능한 최소값은 '%d'입니다.", MIN_NUMBER));
        }

        if (isIncludeGreaterThanMax(numbers)) {
            throw new IllegalArgumentException(String.format("입력가능한 최대값은 '%d' 입니다.", MAX_NUMBER));
        }

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Lotto fromList(final List<Integer> numbers) {
        return new Lotto(numbers);
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
                .collect(Collectors.toList()));
    }

    public static Lotto of(final int... numbers) {
        return new Lotto(Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList()));
    }


    private boolean isIncludeGreaterThanMax(final List<Integer> numbers) {
        return numbers.stream().anyMatch(num -> num > MAX_NUMBER);
    }

    private boolean isIncludeLessThanMin(final List<Integer> numbers) {
        return numbers.stream().anyMatch(num -> num < MIN_NUMBER);
    }

    private boolean isCorrectSize(final List<Integer> numbers) {
        return numbers.size() == NUMBER_SIZE;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int matchedCount(final Lotto winLotto) {
        return (int) numbers.stream()
                .filter(winLotto::contains)
                .count();
    }

    public boolean contains(final Integer number) {
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
