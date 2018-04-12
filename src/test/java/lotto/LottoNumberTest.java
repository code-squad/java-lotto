package lotto;

import lotto.domain.LottoNumber;
import org.junit.Test;

/**
 * @author sangsik.kim
 */
public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 티켓_사이즈_유효성_1미만() {
        LottoNumber lottoNumber = new LottoNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 티켓_사이즈_유효성_45초과() {
        LottoNumber lottoNumber = new LottoNumber(46);
    }
}
