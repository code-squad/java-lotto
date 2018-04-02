package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoNoTest {

    @Test
    public void 유효값테스트_true() {
        assertThat(LottoNo.isValidLottoNo(1), is(true));
        assertThat(LottoNo.isValidLottoNo(45), is(true));
    }

    @Test
    public void 유효값테스트_false() {
        assertThat(LottoNo.isValidLottoNo(0), is(false));
        assertThat(LottoNo.isValidLottoNo(46), is(false));
    }

}
