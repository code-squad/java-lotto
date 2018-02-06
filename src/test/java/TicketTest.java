import domain.*;

import enums.Rank;
import org.junit.Before;
import org.junit.Test;
import utils.Utils;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * Created by hoon on 2018. 1. 13..
 */
public class TicketTest {
    Lotto lotto;
    Lotto lotto1;
    Lotto lotto2;
    Lotto lotto3;
    Lotto bonus;

    @Before
    public void setup() {
        lotto = new Lotto(
                Collections.singletonList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6))),
                1000,
                new WinningTicket(Arrays.asList(45, 44, 43, 4, 5, 6), 1));

        lotto1 = new Lotto(
                Arrays.asList(
                        new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Ticket(Arrays.asList(4, 5, 6, 43, 44, 45)),
                        new Ticket(Arrays.asList(4, 5, 6, 10, 11, 12))
                ),
                3000,
                new WinningTicket(Arrays.asList(45, 44, 43, 4, 5, 6), 3));

        lotto2 = new Lotto(
                Arrays.asList(
                        new Ticket(Arrays.asList(11, 12, 13, 14, 15, 16)),
                        new Ticket(Arrays.asList(4, 5, 6, 43, 44, 45)),
                        new Ticket(Arrays.asList(4, 5, 6, 10, 11, 12))
                ),
                3000,
                new WinningTicket(Arrays.asList(45, 44, 43, 3, 5, 6), 1));

        bonus = new Lotto(
                Collections.singletonList(
                        new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6))
                ),
                1000,
                new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 10), 6));

    }

    @Test
    public void 당첨_테스트() {
        Ticket ticket1 = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticket2 = new Ticket(Arrays.asList(10, 2, 3, 4, 5, 6));
        Ticket ticket3 = new Ticket(Arrays.asList(10, 2, 3, 4, 5, 6));

        assertThat(ticket1.calculateHits(ticket2), is(5));
        assertThat(ticket2.calculateHits(ticket3), is(6));

    }

    @Test
    public void 수익률_테스트() {
        assertThat(Utils.getEarningsRate(1000, lotto.getWinningMoney()), is(400.0));
        assertThat(Utils.getEarningsRate(3000, lotto2.getWinningMoney()), is(999900.0));
    }

    @Test
    public void 세개_매치_전체에서_두개_테스트() {
        assertThat(lotto1.matchedCount(Rank.FIFTH), is(2));
    }

    @Test
    public void 중복없는_랜덤_번호_테스트() {
        assertThat(Utils.generateRandomNumbers(6).size(), is(6));
    }

    @Test
    public void 보너스_테스트() {
        assertThat(bonus.matchedCount(Rank.SECOND), is(1));
        assertThat(lotto1.matchedCount(Rank.SECOND), is(0));
    }

    @Test
    public void 수동구매테스트() {
        lotto3 = new Lotto(
                Arrays.asList(
                        new Ticket(Arrays.asList(11, 12, 13, 14, 15, 16)),
                        new Ticket(Arrays.asList(4, 5, 6, 43, 44, 45)),
                        new Ticket(Arrays.asList(4, 5, 6, 10, 11, 12))
                ),
                4000,
                new WinningTicket(Arrays.asList(45, 44, 43, 3, 5, 6), 1));

        assertThat(lotto3.getTotalTickets().size(), is(4));
    }
}
