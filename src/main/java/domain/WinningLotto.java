package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNum;

    WinningLotto(List<Integer> winningLottoNums, int bonusNum) {
        super(winningLottoNums);
        LottoRules.eligibleForWinningLotto(winningLottoNums, bonusNum);
        this.bonusNum = bonusNum;
    }

    boolean bonusCheck(Lotto lotto) {
        return lotto.contains(bonusNum);
    }
}
