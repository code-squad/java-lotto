package com.codesquad.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    public static final int NUMBER_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public LottoNumber(final List<Integer> numbers) {

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

    public long getMatchedCount(final LottoNumber winNumber) {
        final List<Integer> winNumbers = winNumber.getNumbers();
        return numbers.stream()
                .filter(winNumbers::contains)
                .count();
        //return IntStream.range(0, NUMBER_SIZE - 1)
//                .filter(i -> (winNumbers.get(i)))
//                .count();
    }
}
