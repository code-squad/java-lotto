package vo;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String WRONG_RANGE_LOTTO_NUMBER_MSG = "1과 45 사이의 값을 입력해 주세요";

    private final int number;

    public LottoNumber(int number) {
        if(!isValidNumber(number)) {
            throw new IllegalArgumentException(WRONG_RANGE_LOTTO_NUMBER_MSG);
        }
        this.number = number;
    }

    private boolean isValidNumber(int number) {
        return number <= MAX_NUMBER && number >= MIN_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
