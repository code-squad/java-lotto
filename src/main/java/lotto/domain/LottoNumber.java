package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    private Integer number;

    public LottoNumber() {
        this.number = getRandom();
    }

    public LottoNumber(Integer number) {
        Objects.requireNonNull(number);
        this.number = number;
        if (outOfRange()) throw new IllegalArgumentException();
    }

    private int getRandom() {
        return new Random().nextInt(LOTTO_MAX_NUMBER)+LOTTO_MIN_NUMBER;
    }

    private boolean outOfRange() {
        return number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number;
    }

    public boolean equals(Integer number) {
        return this.number.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}