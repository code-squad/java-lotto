package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TicketTest {
    private Ticket ticket;
    private Ticket winningTicket;

    @Before
    public void setUp() throws Exception {
        List<Number> winningNums = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        winningTicket = new Ticket(winningNums);
        List<Number> numbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        ticket = new Ticket(numbers);
    }

    @Test
    public void findMatch() {
        int matchCount = ticket.countMatchInTicket(winningTicket);
        assertEquals(6, matchCount);
    }
}