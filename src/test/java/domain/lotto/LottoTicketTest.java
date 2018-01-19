package domain.lotto;

import DTO.LottoNumbers;
import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTicketTest {

    LottoTicket a;
    LottoTicket b;

    @Before
    public void init(){
        LottoNumbers numbers = new LottoNumbers(Arrays.asList(new LottoNumber[]{
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        }));

        a = new LottoTicket(numbers);
        b = new LottoTicket(numbers);
    }

    @Test
    public void equals_true() {
        assertThat(a.equals(b), is(true));
    }

    @Test
    public void equals_false() {
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
        LottoNumbers numbers = new LottoNumbers(Arrays.asList(new LottoNumber[]{
                new LottoNumber(1),
                new LottoNumber(11),
                new LottoNumber(21),
                new LottoNumber(31),
                new LottoNumber(41),
                new LottoNumber(12)
        }));
        assertThat(a.winningMaching(numbers), is(WinningRules.ONE_MATCHING));
    }

    @Test
    public void insertNumber(){
        a.insertNumber("1, 2, 3, 4, 5, 6");
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber[]{
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        });

        assertThat(a.getNumbers().getNumbers(), is(numbers));
    }
}
