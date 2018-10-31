package lotto.domain;

import lotto.domain.vo.LottoNumber;
import org.junit.Test;

public class LottoNumberTest {
    @Test
    public void 정상생성() {
        LottoNumber number = LottoNumber.ofInteger(6);
        System.out.println(number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위에러초과() {
        LottoNumber number = LottoNumber.ofInteger(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위에러미만() {
        LottoNumber number = LottoNumber.ofInteger(-1);
    }
}
