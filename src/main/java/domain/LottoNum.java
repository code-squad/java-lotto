package domain;


import java.util.Objects;

public class LottoNum {
    private final int lottoNum;

    public LottoNum(int lottoNum) {
        LottoRules.eligibleForLottoNum(lottoNum);
        this.lottoNum = lottoNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum1 = (LottoNum) o;
        return lottoNum == lottoNum1.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNum);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNum);
    }
}
