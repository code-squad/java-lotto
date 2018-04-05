package saru.domain;

import java.util.Objects;

public class LottoNum {
    private static final int MAX_LOTTO_NUM = 45;
    private static final int START_NUM = 1;

    private int number;

    private LottoNum(int number) {
        this.number = number;
    }

    public static LottoNum of(int number) {
        if (number < START_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("입력값이 정상 범위가 아님");
        }

        return new LottoNum(number);
    }

    public int getNum() {
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
        LottoNum that = (LottoNum) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}


