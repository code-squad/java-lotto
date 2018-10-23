package lotto.domain;

import org.junit.Test;

public class LottoNumberTest {
    @Test
    public void 정상생성() {
        LottoNumber number = new LottoNumber(6);
        System.out.println(number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위에러초과() {
        LottoNumber number = new LottoNumber(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위에러미만() {
        LottoNumber number = new LottoNumber(-1);
    }
}
