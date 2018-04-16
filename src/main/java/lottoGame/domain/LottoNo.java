package lottoGame.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    private int lottoNo;

    public LottoNo(int lottoNo) {

        this.lottoNo =  vaildLottoNo(lottoNo);
    }

    private int vaildLottoNo(int lottoNo) {

        if(lottoNo > 45 || lottoNo < 1) {
            throw new IllegalArgumentException();
        }
        return lottoNo;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }


    @Override
    public int compareTo(LottoNo o) {
        return this.lottoNo - o.lottoNo;
    }


    @Override
    public String toString() {
        return String.valueOf(this.lottoNo);
    }
}
