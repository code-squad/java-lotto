package domain.lotto;

import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber>, Validable<Integer> {

    static final Integer LOTTO_MIN_NUMBER = 1;
    static final Integer LOTTO_MAX_NUMBER = 45;
    private Integer number;

    public LottoNumber() {
    }

    public LottoNumber(Integer number) {
        if (!this.isValidData(number)) {
            return;
        }
        this.number = number;
    }

    public LottoNumber(String number) {
        int nonValidData = Integer.parseInt(number);
        if (!this.isValidData(nonValidData)) {
            return;
        }
        this.number = nonValidData;
    }

    public LottoNumber autoCreateNumber() {
        this.number = new Random().nextInt(LOTTO_MAX_NUMBER) + 1;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public boolean isValidData(Integer data) {
        if (data >= LOTTO_MIN_NUMBER && data <= LOTTO_MAX_NUMBER) {
            return true;
        }
        return false;
    }
}
