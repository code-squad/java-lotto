package lottogame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int CORRECT_LOTTO_NUMBER_AMOUNT = 6;
    public static final int MAXIMUM_LOTTO_NUM = 46;
    private Set<LottoNumber> lotto = new HashSet<>();

    Lotto(List<Integer> lottoNum) {
        for (Integer integer : lottoNum) {
            lotto.add(new LottoNumber(integer));
        }
        inspectNumberAmount();
        inspectDuplication(lottoNum);
        this.lotto = Collections.unmodifiableSet(lotto);
    }

    private void inspectNumberAmount() {
        if (lotto.size() != CORRECT_LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void inspectDuplication(List<Integer> lottoNumber) {
        if (this.lotto.size() != lottoNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    int match(Lotto winningNumber) {
        int cnt = 0;
        for (LottoNumber lottoNumber : winningNumber.lotto) {
            if (this.lotto.contains(lottoNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    boolean isContain(LottoNumber bonusNum) {
        return lotto.contains(bonusNum);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
