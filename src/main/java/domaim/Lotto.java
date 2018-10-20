package domaim;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNum> lottos;

    public Lotto() {
        lottos = new ArrayList<>();
    }

    public Lotto(List<LottoNum> lotto) {
        this.lottos = lotto;
    }

    /* 당첨유무 확인을 위한 번호 체크 메소드 */
    public boolean isContainNumber(Lotto ohterLotto, int index) {
        return lottos.contains(ohterLotto.getLottoNum(index));
    }

    /* 로또 번호 가져오는 메소드 */
    public LottoNum getLottoNum(int index) {
        return lottos.get(index);
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
