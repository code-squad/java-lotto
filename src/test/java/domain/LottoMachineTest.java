package domain;

import View.InputView;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LottoMachineTest {
    LottoMachine lottoMachine;
    int ticketCount;

    @Before
    public void setup() {

    }

    @Test
    public void getLottoTickets() throws Exception {
        int purchaseFee = 10000;
        ticketCount = InputView.getTicketCount(purchaseFee);
        lottoMachine = new LottoMachine(ticketCount);
        assertEquals(10, lottoMachine.getLottoTickets().size());
    }

    @Test
    public void matching() throws Exception {
        lottoMachine = new LottoMachine(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Rank, Integer> result =
                lottoMachine.matching(Arrays.asList(1, 2, 3, 7, 8, 9), 10);
        int value = result.get(Rank.FIFTH);
        assertEquals(1, value);
    }
}
