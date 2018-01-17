package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNoTest {
    @Test
    public void lottoNoTest() {
        LottoNo lottoNo = new LottoNo(1);
        assertThat(lottoNo).isEqualTo(new LottoNo(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_under_one() {
        new LottoNo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_over_45() {
        new LottoNo(46);
    }
}
