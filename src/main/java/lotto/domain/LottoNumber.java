package lotto.domain;

import lotto.util.Constant;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>  {
    private int number;

    public LottoNumber(int number) {
        if (number < Constant.LOTTO_MIN || number > Constant.LOTTO_MAX) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return "" + number;
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
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}
