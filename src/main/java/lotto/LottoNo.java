package lotto;

import java.util.List;

/**
 * Created by Joeylee on 2018-01-26.
 */
public class LottoNo {
    private int no;

    public LottoNo(int no) {
        if(no < 1 || no > 45) {
            throw new IllegalArgumentException("1과 45 사이의 번호를 입력해주세요");
        }
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNo lottoNo = (LottoNo) o;

        return no == lottoNo.no;
    }

    @Override
    public int hashCode() {
        return no;
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }
}
