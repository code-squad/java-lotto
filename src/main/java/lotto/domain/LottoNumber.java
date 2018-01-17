package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(String numberString) {
        return new LottoNumber(Integer.parseInt(numberString));
    }

    private void validate(int number) {
        if (number < LottoConstants.FIRST_NUMBER || number > LottoConstants.LAST_NUMBER) {
            throw new IllegalArgumentException("lottoNumber=" + number);
        }
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
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number == o.number) {
            return 0;
        }

        return (this.number > o.number ) ? 1 : -1;
    }
}
