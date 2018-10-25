package lottogame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int CORRECT_LOTTO_NUMBER_AMOUNT = 6;
    private Set<LottoNumber> lottos = new HashSet<>();

    public Lotto(List<Integer> lottoNum) {
        for (Integer integer : lottoNum) {
            lottos.add(new LottoNumber(integer));
        }
        inspectDuplication(lottoNum);
        inspectNumberAmount();
        this.lottos = Collections.unmodifiableSet(lottos);
    }

    private void inspectNumberAmount() {
        if (lottos.size() != CORRECT_LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("로또의 숫자는 6개여야 합니다.");
        }
    }

    private void inspectDuplication(List<Integer> lottoNumber) {
        if (this.lottos.size() != lottoNumber.size()) {
            throw new IllegalArgumentException("로또의 숫자는 중복되면 안됩니다.");
        }
    }

    int match(Lotto winningNumber) {
        int cnt = 0;
        for (LottoNumber lottoNumber : winningNumber.lottos) {
            if (this.lottos.contains(lottoNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    boolean isContain(LottoNumber bonusNum) {
        return lottos.contains(bonusNum);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
