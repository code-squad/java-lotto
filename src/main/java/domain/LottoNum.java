package domain;

import java.util.Objects;

public class LottoNum {
    public static final int LOTTO_MAX = 45;
    public static final int LOTTO_MIN = 1;
    private int no;

    public LottoNum(int no) {
        if(no < LOTTO_MIN  || no > LOTTO_MAX) {
            throw new IllegalArgumentException(String.format("유효하지 않는 번호를 입력하셨습니다. Lotto 숫자 범위 %d ~ %d", LOTTO_MIN, LOTTO_MAX));
        }
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return no == lottoNum.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
