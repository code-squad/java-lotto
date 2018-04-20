package com.codesquad.lotto.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(i -> LOTTO_NUMBER_MAP.put(i, new LottoNumber(i)));
    }

    private final int number;

    private LottoNumber(final int number) {
        isLessThanMin(number);
        isGreaterThanMax(number);

        this.number = number;
    }

    public static LottoNumber from(final String number) {
        return of(Integer.parseInt(number));
    }

    public static LottoNumber of(final int number) {
        isLessThanMin(number);
        isGreaterThanMax(number);

        return LOTTO_NUMBER_MAP.get(number);
    }

    private static void isGreaterThanMax(final int number) {
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void isLessThanMin(final int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
