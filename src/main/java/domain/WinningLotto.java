package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNum bonusNum;

    WinningLotto(List<LottoNum> winningLottoNums, int bonusNum) {
        super(winningLottoNums);
        this.bonusNum = new LottoNum(bonusNum);
        LottoRules.eligibleForWinningLotto(winningLottoNums, this.bonusNum);
    }

    boolean bonusCheck(Lotto lotto) {
        return lotto.contains(bonusNum);
    }
}
