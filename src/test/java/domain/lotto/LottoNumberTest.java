package domain.lotto;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoNumberTest {

    LottoNumber a;
    LottoNumber b;

    @Test
    public void isValidata_true(){
        a = LottoNumber.of(1);
        assertThat(a.isValidData(1),is(true));
    }

    @Test(expected = NullPointerException.class)
    public void isValidata_false(){
        b = LottoNumber.of(-1);
    }

    @Test
    public void isValidata(){
        for (int i = 0; i < 10000 ; i++) {
            int number = LottoNumber.of().getNumber();
            assertThat(number <= 45 && number >= 0 , is(true));
        }
    }

    @Test
    public void equals_true() {
        a = LottoNumber.of(1);
        b = LottoNumber.of(1);
        assertThat(a.equals(b), is(true));
    }

    @Test
    public void equals_false() {

        a = LottoNumber.of(1);
        b = LottoNumber.of(2);
        assertThat(a.equals(b), is(false));
    }

}
