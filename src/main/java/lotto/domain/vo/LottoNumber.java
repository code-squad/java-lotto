package lotto.domain.vo;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>  {
    private static final int MAX_LOTTO = 45;
    private static final int MIN_LOTTO = 1;

    private int number;

    private LottoNumber(int number) {
        if (number < MIN_LOTTO || number > MAX_LOTTO) {
            throw new IllegalArgumentException("0 ~ 45 사이의 값만 입력해주세요");
        }
        this.number = number;
    }

    public static LottoNumber ofInteger(int number){
        return new LottoNumber(number);
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
