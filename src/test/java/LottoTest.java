import lotto.Lotto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoTest {
    @Test
    public void 자동생성() {
        Lotto lotto = new Lotto();
        int length = lotto.lottoSize();
        assertEquals(6, length);
    }

    @Test
    public void 문자열넣고생성() {
        String winning = "1,2,3,4,5,6";
        Lotto winningNumber = new Lotto(winning);
        int length = winningNumber.lottoSize();
        assertEquals(6, length);
    }
}
