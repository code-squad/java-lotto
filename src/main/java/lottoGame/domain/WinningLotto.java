package lottoGame.domain;

import java.util.List;
import java.util.Set;

public class WinningLotto {

    private Lotto winningLotto;
    private LottoNo bonusBall;

    public WinningLotto(Set<LottoNo> winningLottoNumbers,LottoNo bonusBall) {

        isDuplicateBonusBall(winningLottoNumbers, bonusBall);

        this.winningLotto = new Lotto(winningLottoNumbers);
        this.bonusBall = bonusBall;
    }

    public int getSameLuckNumCnt(Lotto lotto) {
        int cnt = 0;
        for(LottoNo lottoNum : lotto.getLottoNums()) {
            cnt += addContainLuckyNum(cnt, lottoNum);
        }
        return cnt;
    }

    public boolean isContainBonusNum(Lotto lotto) {
        return lotto.isContainBonusNum(bonusBall);
    }

    private int addContainLuckyNum(int cnt, LottoNo lottoNum) {
        if(isContainWinningNum(lottoNum)) {
            return 1;
        }
        return 0;
    }

    private boolean isContainWinningNum(LottoNo lottoNum) {
        return winningLotto.isContainLottoNum(lottoNum);
    }

    private void isDuplicateBonusBall(Set<LottoNo> winningLottoNumbers, LottoNo bonusBall) {
        if(winningLottoNumbers.contains(bonusBall)==true)
            throw new IllegalArgumentException();
    }

}
