package lottoGame.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {
    private static final int MAX_LOTTO_NUM = 45;
    private static final int MIN_LOTTO_NUM = 1;

    private int lottoNo;

    public LottoNo(int lottoNo) {

        this.lottoNo =  vaildLottoNo(lottoNo);
    }

    private int vaildLottoNo(int lottoNo) {

        if(lottoNo > MAX_LOTTO_NUM || lottoNo < MIN_LOTTO_NUM) {
            throw new IllegalArgumentException("LOTTO번호는 1이상 45이하의 수입니다.");
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
