package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TicketTest {
    private Ticket ticket;
    private List<Number> winningNums;

    @Before
    public void setUp() throws Exception {
        winningNums = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5));
        List<Number> numbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5));
        ticket = new Ticket(numbers);
    }

    @Test
    public void findMatch() {
        int matchCount = ticket.countMatch(winningNums);
        assertEquals(5, matchCount);
    }
}