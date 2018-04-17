package lottoGame.domain;

import java.util.List;
import java.util.Set;

public class WinningLotto {

    private Lotto winningLotto;
    private LottoNo bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNo bonusBall) {

        isDuplicateBonusBall(winningLotto, bonusBall);

        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public int getSameLuckNumCount(Lotto lotto) {
        int Count = 0;
        for(LottoNo lottoNum : lotto.getLottoNums()) {
            Count += addContainLuckyNum(Count, lottoNum);
        }
        return Count;
    }

    public boolean isContainBonusNum(Lotto lotto) {
        return lotto.isContainBonusNum(bonusBall);
    }

    private int addContainLuckyNum(int Count, LottoNo lottoNum) {
        if(isContainWinningNum(lottoNum)) {
            return 1;
        }
        return 0;
    }

    private boolean isContainWinningNum(LottoNo lottoNum) {
        return winningLotto.isContainLottoNum(lottoNum);
    }

    private void isDuplicateBonusBall(Lotto winningLottoNumbers, LottoNo bonusBall) {
        if(winningLottoNumbers.isContainBonusNum(bonusBall))
            throw new IllegalArgumentException();
    }

}
