package com.codesquad.lotto.vo;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    private LottoNumber(final int number) {
        this.isLessThanMin(number);
        this.isGreaterThanMax(number);

        this.number = number;
    }

    public static LottoNumber from(final String number) {
        return new LottoNumber(Integer.parseInt(number));
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    private void isGreaterThanMax(final int number) {
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void isLessThanMin(final int number) {
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
