package lotto.domain;

import org.junit.Test;

public class LottoNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성테스트() {
        new LottoNumber(46);
    }
}
