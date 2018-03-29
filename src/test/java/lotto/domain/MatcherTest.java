package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MatcherTest {
    private List<Ticket> tickets;
    private Map<Ticket, Integer> matches;
    private List<Number> winningNums;
    Map<Ticket, Integer> expected;

    @Before
    public void setUp() throws Exception {
        winningNums = Arrays.asList(new Number(1), new Number(2), new Number(6));
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5, 6);
        tickets = Arrays.asList(new Ticket(numbers1), new Ticket(numbers2));
        expected = new HashMap<>();
    }

    @Test
    public void compareTickets() {
        matches = Matcher.compareTickets(winningNums, tickets);
        expected.put(tickets.get(0), 2);
        expected.put(tickets.get(1), 1);
        assertEquals(true, matches.equals(expected));
    }
}