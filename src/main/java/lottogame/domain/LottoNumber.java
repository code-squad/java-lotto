package lottogame.domain;

import java.util.Objects;

public class LottoNumber {
     private final Integer num;

    LottoNumber(Integer num) {
        if (num < 1 || num > Lotto.MAXIMUM_LOTTO_NUM) {
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return num.equals(that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return num.toString();
    }

}
