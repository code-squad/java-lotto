package domain.lotto;

import java.util.Optional;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber>, Validable<Integer> {

    static final Integer LOTTO_MIN_NUMBER = 1;
    static final Integer LOTTO_MAX_NUMBER = 45;
    private Integer number;

    private LottoNumber(Integer number) {
        this.number = Optional.of(number)
                .filter(val -> val>=LOTTO_MIN_NUMBER && val<=LOTTO_MAX_NUMBER)
                .orElse(new Random().nextInt(LOTTO_MAX_NUMBER) + 1);
    }

    public static LottoNumber of(Integer number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(String number) {
        return new LottoNumber(Integer.parseInt(number));
    }

    public static LottoNumber of() {
        return LottoNumber.of(new Random().nextInt(LOTTO_MAX_NUMBER) + 1);
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
        return data >= LOTTO_MIN_NUMBER && data <= LOTTO_MAX_NUMBER;
    }

}
