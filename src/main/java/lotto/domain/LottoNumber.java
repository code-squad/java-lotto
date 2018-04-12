package lotto.domain;

/**
 * @author sangsik.kim
 */
public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int value;

    public LottoNumber(int value) {
        validation(value);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    private void validation(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("INVALID NUMBER");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return this.value == ((LottoNumber) obj).getValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
