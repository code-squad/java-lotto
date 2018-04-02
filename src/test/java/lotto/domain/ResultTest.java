package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultTest {
    private Result result;
    private Ticket ticket;
    private Ticket winningTicket;
    private Number bonusNumber;

    @Before
    public void setUp() throws Exception {
        ticket = new Ticket(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7)));
        winningTicket = new Ticket(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        bonusNumber = new Number(7);
    }

    @Test
    public void drawWin() {
        Rank second = Result.drawWin(ticket, winningTicket, bonusNumber);
        assertThat(Rank.SECOND).isEqualTo(second);
    }

    @Test
    public void calculateProfit() {
        result = new Result(Arrays.asList(ticket), winningTicket, bonusNumber);
        double actual = 30000000 / 1000 * 100;
        assertThat(actual).isEqualTo(result.calculateProfit());
    }
}