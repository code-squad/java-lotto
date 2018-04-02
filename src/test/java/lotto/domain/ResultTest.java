package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultTest {
    private Ticket ticket;
    private WinningLotto winningLotto;

    @Before
    public void setUp() throws Exception {
        List<Number> winningTicket = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Number bonusNumber = new Number(7);

        winningLotto = new WinningLotto(winningTicket, bonusNumber);
        ticket = new Ticket(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7));
    }

    @Test
    public void drawWin() {
        Match second = Result.compareTicket(ticket, winningLotto);
        assertThat(Match.SECOND).isEqualTo(second);
    }

    @Test
    public void calculateProfit() {

        Result result = new Result(Arrays.asList(ticket), winningLotto);
        double actual = 30000000 / 1000 * 100;
        assertThat(actual).isEqualTo(result.calculateProfit());
    }
}