package lotto.vo;

import java.util.Objects;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public int toNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.toNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
