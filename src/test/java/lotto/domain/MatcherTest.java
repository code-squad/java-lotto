package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MatcherTest {
    private List<Ticket> tickets;
    private List<Number> winningNums;

    @Before
    public void setUp() throws Exception {
        List<Number> try1 = Arrays.asList(new Number(1), new Number(2), new Number(3));
        List<Number> try2 = Arrays.asList(new Number(4), new Number(5), new Number(6));
        tickets = Arrays.asList(new Ticket(try1), new Ticket(try2));
        winningNums = Arrays.asList(new Number(1), new Number(2), new Number(6));
    }

    @Test
    public void compareTickets() {
        List<Integer> actual = Matcher.compareTickets(winningNums, tickets);
        List<Integer> expected = Arrays.asList(2, 1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}