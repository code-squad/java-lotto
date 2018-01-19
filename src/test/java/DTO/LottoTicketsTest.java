package DTO;

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
        LottoTicket winningTicket = new LottoTicket();
        winningTicket.insertNumber("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = new LottoTicket();
        ticket1.insertNumber("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = new LottoTicket();
        ticket2.insertNumber("7, 8, 9, 10, 11, 12");
        LottoTicket ticket3 = new LottoTicket();
        ticket3.insertNumber("13, 14, 15, 16, 17, 18");
        LottoTicket ticket4 = new LottoTicket();
        ticket4.insertNumber("19, 20, 21, 22, 23, 24");
        LottoTicket ticket5 = new LottoTicket();
        ticket5.insertNumber("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = new LottoTicket();
        ticket6.insertNumber("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = new LottoTicket();
        ticket7.insertNumber("37, 38, 39, 40, 41, 42");

        tickets = new LottoTickets(Arrays.asList(
                ticket1,
                ticket2,
                ticket3,
                ticket4,
                ticket5,
                ticket6,
                ticket7
        ));

        List<WinningRules> matching = tickets.findMatching(winningTicket);

        assertThat(matching.get(0), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void findMatching_여러개() {
        LottoTicket winningTicket = new LottoTicket();
        winningTicket.insertNumber("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = new LottoTicket();
        ticket1.insertNumber("1, 2, 3, 4, 5, 6");//6개
        LottoTicket ticket2 = new LottoTicket();
        ticket2.insertNumber("1, 2, 3, 10, 11, 12");//3개
        LottoTicket ticket3 = new LottoTicket();
        ticket3.insertNumber("4, 5, 6, 16, 17, 18");//3개
        LottoTicket ticket4 = new LottoTicket();
        ticket4.insertNumber("5, 6, 21, 22, 23, 24");//2개
        LottoTicket ticket5 = new LottoTicket();
        ticket5.insertNumber("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = new LottoTicket();
        ticket6.insertNumber("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = new LottoTicket();
        ticket7.insertNumber("37, 38, 39, 40, 41, 42");

        tickets = new LottoTickets(Arrays.asList(
                ticket1,
                ticket2,
                ticket3,
                ticket4,
                ticket5,
                ticket6,
                ticket7
        ));

        List<WinningRules> matching = tickets.findMatching(winningTicket);

        List<WinningRules> answer = Arrays.asList(
            WinningRules.SIX_MATCHING,
            WinningRules.THREE_MATCHING,
            WinningRules.THREE_MATCHING
        );

        assertThat(matching, is(answer));
    }
}
