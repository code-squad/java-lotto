package com.zingoworks.lotto.model.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MINIMUM_RANGE = 1;
    public static final int MAXIMUM_RANGE = 45;

    private int number;

    private LottoNumber(int number) {
        this.number = isValidRange(number);
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(String number) {
        return new LottoNumber(Integer.parseInt(number));
    }

    private int isValidRange(int number) {
        if(number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 유효합니다.");
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
