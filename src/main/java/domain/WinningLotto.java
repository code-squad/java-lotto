package domain;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;

public class WinningLotto {
    private LottoNum bonusBall;
    private List<LottoNum> winningLottos;

    public WinningLotto(List<LottoNum> winningLottos, LottoNum bonusBall) {
        this.winningLottos = winningLottos;
        this.bonusBall = bonusBall;
        if(isDuplicationLottoNumber(winningLottos)) {
            throw new InputMismatchException("중복된 로또 결과 번호 입력했습니다.");
        }

        if(isDuplicationBonusNumber(bonusBall)) {
            throw new InputMismatchException("로또 결과 번호와 동일한 보너스 볼 번호를 입력하셨습니다.");
        }
    }

    /* 보너스볼 번호가 로또 결과번호와 동일한지 확인하는 메소드 */
    protected boolean isDuplicationBonusNumber(LottoNum bonusBall) {
        return winningLottos.contains(bonusBall);
    }

    /* 당첨번호에 중복된 번호가 있는지 확인하는 메소드 */
    protected static boolean isDuplicationLottoNumber(List<LottoNum> lottoNums) {
        if(new HashSet<LottoNum>(lottoNums).size() < Lotto.LOTTO_NUMBER_COUNT) {
            return true;
        }
        return false;
    }

    /* 로또 번호와 당첨번호 결과를 매칭해서 로또 결과를 반환 */
    public LottoResult confirmLottoResult(Lotto lotto) {
        int cnt = 0;
        for(int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            cnt = this.winningLottos.contains(lotto.getLottoNum(i)) ? cnt + 1 : cnt;
        }
        return LottoResult.obtainLottoResult(cnt, confirmBonusHit(lotto));
    }

    /* 보너즈 적중 유무 확인하는 메소드 */
    public int confirmBonusHit(Lotto lotto) {
        if(lotto.isContainLottoNum(bonusBall)) {
            return 1;
        }
        return 0;
    }
}
