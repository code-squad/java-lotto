package lottogame;

import java.util.Objects;

public class LottoNo {
    private int number;

    public LottoNo(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("각 숫자는 1에서 45사이의 값이어야 합니다.");
        }
        this.number = number;
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

    @Override
    public String toString() {
        return number + "";
    }
}
