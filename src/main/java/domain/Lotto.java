package domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNum> lottos;

    Lotto(List<LottoNum> lottos) {
        this.lottos = lottos;
    }

    /* 로또 번호 가져오는 메소드 */
    public LottoNum getLottoNum(int index) {
        return lottos.get(index);
    }

    /* 파라미터로 전달받은 로또 번호가 로또에 있는지 확인하는 메소드 */
    public boolean isContainLottoNum(LottoNum lottoNum) {
        return lottos.contains(lottoNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottos, lotto1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
