package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNum bonusNum;

    private WinningLotto(List<LottoNum> winningLottoNums, LottoNum bonusNum) {
        super(winningLottoNums);
        this.bonusNum = bonusNum;
    }

    public static WinningLotto ofWinningLotto(List<LottoNum> winningLottoNums, int bonusNum) {
        LottoNum newBonusNum = LottoNum.ofLottoNum(bonusNum);
        ofLotto(winningLottoNums);
        if (winningLottoNums.contains(newBonusNum)) {
            throw new IllegalArgumentException("[보너스 수와 로또 수 중 같은 값이 있습니다!]");
        }
        return new WinningLotto(winningLottoNums, newBonusNum);
    }

    boolean bonusCheck(Lotto lotto) {
        return lotto.contains(bonusNum);
    }
}
