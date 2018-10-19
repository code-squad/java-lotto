package domain;

import vo.No;
import vo.Rank;

public class WinningLotto {
    private Lotto winLotto;
    private No bonusNum;

    public WinningLotto(Lotto winLotto, No bonusNum) {
        this.winLotto = winLotto;
        this.bonusNum = checkWinningBonus(winLotto, bonusNum);
    }

    public Rank compareWinLottoNum(Lotto lotto) {
        return Rank.findMatchRank(this.winLotto.compareLottoNumbs(lotto), lotto.checkBonusNum(this.bonusNum));
    }

    private No checkWinningBonus(Lotto winLotto, No bonusNum) {
        if (winLotto.checkBonusNum(bonusNum))
            throw new IllegalArgumentException("Bonus 번호는 로또번호와 같을 수 없습니다.");
        return bonusNum;
    }

}
