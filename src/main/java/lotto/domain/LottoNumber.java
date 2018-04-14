package lotto.domain;

/**
 * @author sangsik.kim
 */
public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int value;

    private LottoNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("INVALID NUMBER");
        }
        this.value = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return this.value == ((LottoNumber) obj).value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        return this.value;
    }
}