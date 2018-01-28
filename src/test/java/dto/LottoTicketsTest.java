package dto;

import domain.lotto.LottoNumber;
import domain.lotto.LottoTicket;
import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTicketsTest {

    LottoTickets tickets;

    @Before
    public void init(){

    }

    @Test
    public void findMatching_하나() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = LottoTicket.of("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = LottoTicket.of("7, 8, 9, 10, 11, 12");
        LottoTicket ticket3 = LottoTicket.of("13, 14, 15, 16, 17, 18");
        LottoTicket ticket4 = LottoTicket.of("19, 20, 21, 22, 23, 24");
        LottoTicket ticket5 = LottoTicket.of("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = LottoTicket.of("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = LottoTicket.of("37, 38, 39, 40, 41, 42");

        tickets = new LottoTickets(Arrays.asList(
                ticket1,
                ticket2,
                ticket3,
                ticket4,
                ticket5,
                ticket6,
                ticket7
        ));

        List<WinningRules> matching = tickets.findMatching(winningTicket, LottoNumber.of(45));

        assertThat(matching.get(0), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void findMatching_여러개() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = LottoTicket.of("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = LottoTicket.of("1, 2, 3, 10, 11, 12");
        LottoTicket ticket3 = LottoTicket.of("4, 5, 6, 16, 17, 18");
        LottoTicket ticket4 = LottoTicket.of("5, 6, 21, 22, 23, 24");
        LottoTicket ticket5 = LottoTicket.of("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = LottoTicket.of("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = LottoTicket.of("37, 38, 39, 40, 41, 42");

        tickets = new LottoTickets(Arrays.asList(
                ticket1,
                ticket2,
                ticket3,
                ticket4,
                ticket5,
                ticket6,
                ticket7
        ));

        List<WinningRules> matching = tickets.findMatching(winningTicket, LottoNumber.of(45));

        List<WinningRules> answer = Arrays.asList(
            WinningRules.SIX_MATCHING,
            WinningRules.THREE_MATCHING,
            WinningRules.THREE_MATCHING
        );

        assertThat(matching, is(answer));
    }

    @Test
    public void findMatching_보너스볼() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = LottoTicket.of("1, 2, 3, 4, 5, 45");

        tickets = new LottoTickets(Arrays.asList(
                ticket1
        ));

        List<WinningRules> matching = tickets.findMatching(winningTicket, LottoNumber.of(45));

        List<WinningRules> answer = Arrays.asList(
                WinningRules.BONUS_MATCHING
        );

        assertThat(matching, is(answer));
    }
}
