package lottogame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int CORRECT_LOTTO_NUMBER_AMOUNT = 6;
    private Set<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = new HashSet<>(lottoNumber);
        inspectNumberAmount(lottoNumber);
        inspectDuplication(lottoNumber);
    }

    private void inspectNumberAmount(List<Integer> lottoNumber) {
        if (lottoNumber.size() != CORRECT_LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void inspectDuplication(List<Integer> lottoNumber) {
        if(this.lottoNumber.size() != lottoNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    int check(Lotto winningNumber) {
        int cnt = 0;
        for (Integer integer : winningNumber.lottoNumber) {
            if (this.lottoNumber.contains(integer)) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
