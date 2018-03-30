package saru.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MAX_LOTTO_NUM = 45;
    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < 0 || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException();
        }

        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
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
}


