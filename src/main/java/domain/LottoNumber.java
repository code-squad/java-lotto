package domain;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        checkArgument(number);
        this.number = number;
    }

    private void checkArgument(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다. 1~45까지의 숫자만 가능합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof LottoNumber)) { return false; }

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
