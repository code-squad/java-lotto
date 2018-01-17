package domain.lotto;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoNumberTest {

    LottoNumber a;
    LottoNumber b;

    @Before
    public void init() {

    }

    @Test
    public void equals_true() {
        a = new LottoNumber(1);
        b = new LottoNumber(1);
        assertThat(a.equals(b), is(true));
    }

    @Test
    public void equals_false() {

        a = new LottoNumber(1);
        b = new LottoNumber(2);
        assertThat(a.equals(b), is(false));
    }

}
