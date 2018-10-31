package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNum> lottoNums;

    protected Lotto(List<LottoNum> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public static Lotto ofLotto(List<LottoNum> lottoNums) {
        Set<LottoNum> nums = new HashSet<>(lottoNums);
        if (lottoNums.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[로또 수가 6개가 아닙니다!]");
        }
        if (nums.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[로또 수 중 중복되는 수가 있습니다.]");
        }
        return new Lotto(lottoNums);
    }

    int strikeCheck(Lotto target) {
        int strikePoint = 0;
        for (LottoNum lottoNum : lottoNums) {
            strikePoint += addStrikePoint(target.lottoNums.contains(lottoNum));
        }
        return strikePoint;
    }

    int addStrikePoint(boolean isStrike) {
        if (isStrike) {
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
