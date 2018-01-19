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
        a = new LottoNumber();
    }

    @Test
    public void isValidata_true(){
        a = new LottoNumber(1);
        assertThat(a.isValidData(1),is(true));
    }

    @Test(expected = NullPointerException.class)
    public void isValidata_false(){
        b = new LottoNumber(-1);
    }

    @Test
    public void isValidata(){
        for (int i = 0; i < 10000 ; i++) {
            int number = a.autoCreateNumber().getNumber();
            assertThat(number <= 45 && number >= 0 , is(true));
        }
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
