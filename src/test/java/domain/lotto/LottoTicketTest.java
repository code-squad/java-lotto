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

        number1.add(LottoNumber.of(1));
        number1.add(LottoNumber.of(2));
        number1.add(LottoNumber.of(3));
        number1.add(LottoNumber.of(4));
        number1.add(LottoNumber.of(5));
        number1.add(LottoNumber.of(6));

        numbers = LottoNumbers.of(number1);

        a = LottoTicket.of(numbers);
        b = LottoTicket.of(numbers);
    }

    @Test
    public void equals_true() {
        assertThat(a.equals(b), is(true));
    }

    @Test
    public void equals_false() {
        b = LottoTicket.of("1, 2, 3, 4, 5, 7");
        assertThat(a.equals(b), is(false));
    }

    @Test
    public void winningMaching_SIX() {
        a = LottoTicket.of("1, 2, 3, 4, 5, 6");
        assertThat(a.matching(a, LottoNumber.of(45)), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void winningMaching_ONE() {
        LottoTicket lottoTicket = LottoTicket.of("1, 7, 8, 9, 10, 11");

        assertThat(lottoTicket.matching(a, LottoNumber.of(45)), is(WinningRules.NONE));
    }

    @Test
    public void insertNumber() {
        LottoTicket lottoTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");

        assertThat(lottoTicket, is(a));
    }
}
