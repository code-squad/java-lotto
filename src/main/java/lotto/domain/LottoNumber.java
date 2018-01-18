package lotto.domain;

import lotto.util.LottoUtil;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private Integer number;

    public LottoNumber() {
        this.number = LottoUtil.getRandom();
    }

    public LottoNumber(String number) {
        if (LottoUtil.canLottoNumber(number)) throw new IllegalArgumentException();
        makeLottoNumber(Integer.parseInt(number));
    }

    public LottoNumber(Integer number) {
        if (LottoUtil.canLottoNumber(number)) throw new IllegalArgumentException();
        makeLottoNumber(number);
    }

    private void makeLottoNumber(Integer number) {
        this.number = number;
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

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}