import lottogame.Lotto;
import lottogame.LottoFactory;
import lottogame.LottoNo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class LottoTest {
    /**
     * 테스트 케이스 정리
     * 1. 로또6개번호선택∂
     */

    @Test
    public void 로또6개번호선택() {
        Lotto lotto = new Lotto();
        for (int i = 1; i <= 45; i++) {
            lotto.add(new LottoNo(i));
        }
        assertEquals(6, LottoFactory.chooseSixNumber(lotto).getSize());
    }
}