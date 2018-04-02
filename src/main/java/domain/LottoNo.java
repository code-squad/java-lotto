package domain;

import domain.exceptions.InvalidBallException;

import java.util.Objects;

public class LottoNo {

    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_INCLUSIVE = 45;
    private final int num;

    private LottoNo(int num) {
        if (!isValidLottoNo(num)) {
            throw new InvalidBallException(String.format("입력값은 1-45사이 입니다. 입력값 : %d", num));
        }
        this.num = num;
    }

    static boolean isValidLottoNo(int num) {
        return MIN_INCLUSIVE < num && num <= MAX_INCLUSIVE;
    }

    public static LottoNo of(int num) {
        return new LottoNo(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return num == lottoNo.num;
    }

    @Override
    public int hashCode() {

        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}
