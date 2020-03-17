package domain;

import org.junit.Test;

public class LottoNumberTest {

    @Test
    public void 개별로또숫자생성() {
        for (int i = 1; i <= 45; i++) {
            new LottoNumber(i);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개별로또숫자생성_최대초과() {
        new LottoNumber(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개별로또숫자생성_최소미만() {
        new LottoNumber(0);
    }
}
