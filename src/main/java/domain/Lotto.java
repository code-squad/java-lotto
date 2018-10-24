package domain;

import java.util.List;

import static utils.LottoGameValues.LOTTO_SIZE;

public class Lotto {
    private final List<Integer> lottoNums;

    public Lotto(List<Integer> lottoNums) {
        LottoRules.eligibleForLotto(lottoNums);
        this.lottoNums = lottoNums;
    }

    int strikeCheck(Lotto target) {
        int strikePoint = 0;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            strikePoint += contains(target, lottoNums.get(i));
        }
        return strikePoint;
    }

    int contains(Lotto target, int num) {
        if(target.lottoNums.contains(num)) {
            return 1;
        }
        return 0;
    }

    boolean contains(int num) {
        return lottoNums.contains(num);
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

}
