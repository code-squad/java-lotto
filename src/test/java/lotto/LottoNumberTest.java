package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumber_음수() throws Exception {
        new LottoNumber(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void LottoNumber_범위밖에숫자() throws Exception {
        new LottoNumber(46);
    }

    @Test
    public void equals() throws Exception {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
        assertThat(new LottoNumber(3)).isNotEqualTo(new LottoNumber(4));
    }
}