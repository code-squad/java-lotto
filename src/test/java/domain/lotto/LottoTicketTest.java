package domain.lotto;

import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTicketTest {

    LottoTicket a;
    LottoTicket b;

    @Before
    public void init(){
        a = new LottoTicket();
        b = new LottoTicket();
    }

    @Test
    public void equals_true() {

        a.insertNumber("1, 2, 3, 4, 5, 6");
        b.insertNumber("1, 2, 3, 4, 5, 6");
        assertThat(a.equals(b), is(true));
    }

    @Test
    public void equals_false() {

        a.insertNumber("1, 2, 3, 4, 5, 6");
        b.insertNumber("1, 2, 3, 4, 5, 7");
        assertThat(a.equals(b), is(false));
    }

    @Test
    public void winningMaching_SIX(){
        a.insertNumber("1, 2, 3, 4, 5, 6");
        assertThat(a.winningMaching(a.getNumbers()), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void winningMaching_ONE(){
        a.insertNumber("1, 2, 3, 4, 5, 6");
        List<LottoNumber> numbers = new ArrayList(){{
            add(new LottoNumber(1));
            add(new LottoNumber(11));
            add(new LottoNumber(21));
            add(new LottoNumber(31));
            add(new LottoNumber(41));
            add(new LottoNumber(12));
        }};
        assertThat(a.winningMaching(numbers), is(WinningRules.ONE_MATCHING));
    }

    @Test
    public void insertNumber(){
        a.insertNumber("1, 2, 3, 4, 5, 6");
        List<LottoNumber> numbers = new ArrayList(){{
            add(new LottoNumber(1));
            add(new LottoNumber(2));
            add(new LottoNumber(3));
            add(new LottoNumber(4));
            add(new LottoNumber(5));
            add(new LottoNumber(6));
        }};

        assertThat(a.getNumbers(), is(numbers));
    }
}
