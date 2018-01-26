package lotto;

import java.util.List;

/**
 * Created by Joeylee on 2018-01-26.
 */
public class LottoNo {
    private int no;

    public LottoNo(int no) {
        this.no = no;
    }
    public boolean matchInList(List<LottoNo> lottoNumbers) {
        return lottoNumbers.contains(this);
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
