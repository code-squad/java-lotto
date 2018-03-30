package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ResultTest {
    private Result result;
    private List<Ticket> tickets;
    private List<Number> winningNums;

    @Before
    public void setUp() throws Exception {
        List<Number> ticket1 = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        List<Number> ticket2 = Arrays.asList(new Number(7), new Number(8), new Number(9), new Number(10), new Number(11), new Number(12));
        List<Number> ticket3 = Arrays.asList(new Number(13), new Number(14), new Number(15), new Number(16), new Number(17), new Number(18));
        tickets = Arrays.asList(new Ticket(ticket1), new Ticket(ticket2), new Ticket(ticket3));
        winningNums = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
    }

    @Test
    public void countFirstPlaceTest() {
        result = new Result(winningNums, tickets);
        assertEquals(1, result.countFirstPlace());
    }

    @Test
    public void countSecondPlaceTest() {
        winningNums.set(0, new Number(45));
        result = new Result(winningNums, tickets);
        assertEquals(1, result.countSecondPlace());
    }

    @Test
    public void countThirdPlaceTest() {
        winningNums.set(1, new Number(45));
        winningNums.set(2, new Number(44));
        result = new Result(winningNums, tickets);
        assertEquals(1, result.countThirdPlace());
    }

    @Test
    public void countFourthPlaceTest() {
        winningNums.set(1, new Number(45));
        winningNums.set(2, new Number(44));
        winningNums.set(3, new Number(43));
        result = new Result(winningNums, tickets);
        assertEquals(1, result.countFourthPlace());
    }

    @Test
    public void calculateProfitTest() {
        result = new Result(winningNums, tickets);
        int first = result.countFirstPlace();
        int second = result.countSecondPlace();
        int third = result.countThirdPlace();
        int fourth = result.countFourthPlace();
        double profit = result.calculateProfit(first, second, third, fourth);
        double expected = (double) 2000000000 / (3 * 1000) * 100; // first place price divided by total cost(tickets bought)
        assertEquals(expected, profit, 0.01);
    }
}