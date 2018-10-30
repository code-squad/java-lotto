package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNum bonusNum;

    WinningLotto(List<LottoNum> winningLottoNums, int bonusNum) {
        super(winningLottoNums);
        this.bonusNum = new LottoNum(bonusNum);
        for (LottoNum lottoNum : winningLottoNums) {
            if(lottoNum.equals(this.bonusNum)) {
                throw new IllegalArgumentException("[보너스 수와 로또 수 중 같은 값이 있습니다!]");
            }
        }
    }

    boolean bonusCheck(Lotto lotto) {
        return lotto.contains(bonusNum);
    }
}
