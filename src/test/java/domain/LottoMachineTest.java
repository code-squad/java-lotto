package domain;

import View.InputView;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LottoMachineTest {
    LottoMachine lottoMachine;
    int ticketCount;


    @Test
    public void getLottoTickets() throws Exception {
        int purchaseFee = 10000;
        ticketCount = InputView.getTicketCount(purchaseFee);
        lottoMachine = new LottoMachine(ticketCount);
        assertEquals(10, lottoMachine.getLottoTickets().size());
    }

    @Test
    public void matching() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(LottoNo.getLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoMachine = new LottoMachine(lottoTickets);
        Map<Rank, Integer> result =
                lottoMachine.matching(
                        LottoNo.getLottoNos(Arrays.asList(1, 2, 3, 7, 8, 9)),
                        new LottoNo(10));
        int value = result.get(Rank.FIFTH);
        assertEquals(1, value);
    }
}
