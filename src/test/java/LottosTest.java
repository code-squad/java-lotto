import lottogame.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class LottosTest {
    /**
     * 테스트 케이스 정리
     * 1. 랭킹확인
     */

    @Test
    public void 랭킹확인() {
        Lottos lottos = new Lottos();
        lottos.add(LottoFactory.createManualLotto("1,2,3,4,5,6"));

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,14");
        winningLotto.addBonusNumber(new LottoNo(7));
        assertEquals(Rank.THIRD, lottos.getRanks(winningLotto).get(0));
    }
}