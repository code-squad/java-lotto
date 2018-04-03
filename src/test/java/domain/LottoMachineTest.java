package domain;

import View.InputView;
import domain.LottoMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoMachineTest {
    LottoMachine lottoMachine;
    int ticketCount;

    @Before
    public void setup() {
        int purchaseFee = 10000;
        ticketCount = InputView.getTicketCount(purchaseFee);
        lottoMachine = new LottoMachine(ticketCount);
    }

    @Test
    public void getLottoTickets() {
        assertEquals(10, lottoMachine.getLottoTickets().size());
    }
}
