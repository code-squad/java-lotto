package lotto;

import lotto.domain.LottoTicket;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoStoreTest {
    @Test
    public void buyRandomTicket() {
        assertEquals(LottoTicket.class, LottoStore.buyRandomTicket().getClass());
    }

    @Test
    public void countTicket() {
        assertEquals(14, LottoStore.countTicket(14000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void countTicketWithIllegalAmount() {
        LottoStore.countTicket(13500);
    }

    @Test
    public void buyRandomTickets() throws Exception {
        assertEquals(14, LottoStore.buyRandomTickets(14).showTicketMessages().size());
        assertEquals(1, LottoStore.buyRandomTickets(1).showTicketMessages().size());
    }
}