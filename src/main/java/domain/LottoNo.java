package domain;

import java.util.Objects;

import static domain.LottoNumCreator.LOTTO_POOL_MAX_NUM;

public class LottoNo {
    private int no;

    public LottoNo(int no) {
        if(!isValidNo(no))
            throw new IllegalArgumentException("Invalid number for LottoNo");

        this.no = no;
    }

    private boolean isValidNo(int no) {
        return no > 0 && no <= LOTTO_POOL_MAX_NUM;
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
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }
}
