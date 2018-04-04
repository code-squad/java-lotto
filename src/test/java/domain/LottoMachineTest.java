package domain;

import View.InputView;
import domain.LottoMachine;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LottoMachineTest {
    LottoMachine lottoMachine;
    int ticketCount;

    @Before
    public void setup() throws Exception {
        int purchaseFee = 10000;
        ticketCount = InputView.getTicketCount(purchaseFee);
        lottoMachine = new LottoMachine(ticketCount);
    }

    @Test
    public void getLottoTickets() {
        assertEquals(10, lottoMachine.getLottoTickets().size());
    }

    @Test
    public void matching() throws Exception {
        LottoMachine lottoMachine = new LottoMachine(1);
        lottoMachine.makeLottoTickets(Arrays.asList(1,2,3,4,5,6));
        HashMap<Rank, Integer> result =
                lottoMachine.matching(Arrays.asList(1,2,3,7,8,9), 10);
        int value = result.get(Rank.FIFTH);
        assertEquals(1, value);
    }
}
