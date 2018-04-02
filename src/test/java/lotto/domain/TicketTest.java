package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TicketTest {
    private Ticket ticket;
    private WinningLotto winningLotto;

    @Before
    public void setUp() throws Exception {
        List<Number> winningNums = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        winningLotto = new WinningLotto(winningNums, new Number(1));

        List<Number> numbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        ticket = new Ticket(numbers);
    }

    @Test
    public void findMatch() {
        int matchCount = winningLotto.countMatchInTicket(ticket);
        assertEquals(6, matchCount);
    }

    @Test
    public void bonusMatch() {
        boolean bonus = winningLotto.bonusMatch(ticket);
        assertEquals(true, bonus);
    }
}