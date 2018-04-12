import LottoGame.Lotto;
import LottoGame.LottoNo;
import LottoGame.LottoNos;
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
        LottoNos lottoNos = new LottoNos();
        for (int i = 1; i <= 45; i++) {
            lottoNos.add(new LottoNo(i));
        }
        assertEquals(6, Lotto.chooseSixNumber(lottoNos).getSize());
    }
}