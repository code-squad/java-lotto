import lottogame.Lotto;
import lottogame.LottoNo;
import lottogame.WinningLotto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 11..
 */
public class WinningLottoTest {

    /**
     * 테스트 케이스 정리
     * 1. 매치 카운트 확인
     * 2. 보너스 번호 매치확인
     */
    @Test
    public void 매치카운트확인() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        winningLotto.addBonusNumber(new LottoNo(7));
        Lotto lotto = new Lotto();
        for (int i = 1; i <= 6; i++) {
            lotto.add(new LottoNo(i));
        }
        assertEquals(6, winningLotto.getMatchCount(lotto));
    }

    @Test
    public void 보너스번호매치확인() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        winningLotto.addBonusNumber(new LottoNo(7));
        Lotto lotto = new Lotto();
        for (int i = 1; i <= 6; i++) {
            lotto.add(new LottoNo(i));
        }
        assertEquals(false, winningLotto.matchBonus(lotto));
    }
}