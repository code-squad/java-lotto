package domain;

import java.util.Objects;

public class LottoNo {
    private int number;

    public LottoNo(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("로또 번호는 1~45까지 입니다.");
        }
        this.number = number;
    }

    public LottoNo(String number) {
        this(Integer.parseInt(number));
    }

    public boolean hasNumber(int number) {
        return this.number == number;
    }

    public static boolean isValid(int number) {
        return number > 0 && number < 46;
    }

    public boolean isEmpty() {
        if (number == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
