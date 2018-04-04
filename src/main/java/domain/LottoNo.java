package domain;

import java.util.Objects;

public class LottoNo {
    private int number;

    public LottoNo(int number) {
        this.number = number;
    }

    public LottoNo(String number) {
        this(Integer.parseInt(number));
    }

    public boolean isValid(int number) {
        if (number > 0 && number < 46) {
            return true;
        }
        return false;
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
