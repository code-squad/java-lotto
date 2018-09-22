package lotto.domain;

import java.util.Objects;

public class LottoNo {
    private int lottoNo;

    public LottoNo(int lottoNo){
        if(lottoNo < 1 || lottoNo > 45){
            throw new IllegalArgumentException("입력된 숫자가 1~45 사이어야합니다.");
        }
        this.lottoNo = lottoNo;
    }

    public int getLottoNo() {
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
}
