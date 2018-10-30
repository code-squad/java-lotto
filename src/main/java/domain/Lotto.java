package domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNum> lottoNums;

    public Lotto(List<LottoNum> lottoNums) {
        LottoRules.eligibleForLotto(lottoNums);
        this.lottoNums = lottoNums;
    }

    int strikeCheck(Lotto target) {
        int strikePoint = 0;
        for (LottoNum lottoNum : lottoNums) {
            strikePoint += addStrikePoint(target.lottoNums.contains(lottoNum));
        }
        return strikePoint;
    }

    int addStrikePoint(boolean isStrike) {
        if(isStrike) {
            return 1;
        }
        return 0;
    }

    boolean contains(LottoNum num) {
        return lottoNums.contains(num);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNums);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNums, lotto.lottoNums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNums);
    }
}
