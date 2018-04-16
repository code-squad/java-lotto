package lottoGame.domain;

import java.util.List;
import java.util.Set;

public class WinningLotto {

    private Set<Integer> winningLottoNumbers;
    private int bonusBall;

    public WinningLotto(Set<Integer> winningLottoNumbers,int bonusBall) {

        isDuplicateBonusBall(winningLottoNumbers, bonusBall);

        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public int getSameLuckNumCnt(Lotto lotto) {
        int cnt = 0;
        for(int lottoNum : lotto.getLottoNums()) {
            cnt += addContainLuckyNum(cnt, lottoNum);
        }
        return cnt;
    }

    public boolean isContainBonusNum(Lotto lotto) {
        return lotto.isContainBonusNum(bonusBall);
    }

    private int addContainLuckyNum(int cnt, int lottoNum) {
        if(isContainWinningNum(lottoNum)) {
            return 1;
        }
        return 0;
    }

    private boolean isContainWinningNum(int lottoNum) {
        return winningLottoNumbers.contains(lottoNum);
    }

    private void isDuplicateBonusBall(Set<Integer> winningLottoNumbers, int bonusBall) {
        if(winningLottoNumbers.contains(bonusBall)==true)
            throw new IllegalArgumentException();
    }

}
