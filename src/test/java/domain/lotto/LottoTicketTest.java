package domain.lotto;

import dto.LottoNumbers;
import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTicketTest {

    LottoTicket a;
    LottoTicket b;
    LottoNumbers numbers;

    @Before
    public void init() {
        SortedSet<LottoNumber> number1;

        number1 = new TreeSet<>();

        number1.add(new LottoNumber(1));
        number1.add(new LottoNumber(2));
        number1.add(new LottoNumber(3));
        number1.add(new LottoNumber(4));
        number1.add(new LottoNumber(5));
        number1.add(new LottoNumber(6));

        numbers = new LottoNumbers(number1);

        a = new LottoTicket(numbers);
        b = new LottoTicket(numbers);
    }

    @Test
    public void equals_true() {
        assertThat(a.equals(b), is(true));
    }

    @Test
    public void equals_false() {
        b = new LottoTicket("1, 2, 3, 4, 5, 7");
        assertThat(a.equals(b), is(false));
    }

    @Test
    public void winningMaching_SIX() {
        a = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(a.matching(a, new LottoNumber(45)), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void winningMaching_ONE() {
        LottoTicket lottoTicket = new LottoTicket("1, 7, 8, 9, 10, 11");

        assertThat(lottoTicket.matching(a, new LottoNumber(45)), is(WinningRules.ONE_MATCHING));
    }

    @Test
    public void insertNumber() {
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");

        assertThat(lottoTicket, is(a));
    }
}
