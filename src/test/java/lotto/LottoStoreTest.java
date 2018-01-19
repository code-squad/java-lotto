package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LottoStoreTest {
    @Test
    public void buyRandomTicket() {
        assertEquals(LottoTicket.class, LottoStore.buyRandomTicket().getClass());
    }

    @Test
    public void countTicketNormal1() {
        assertEquals(4, LottoStore.countRandomTicket(14000, 10));
    }

    @Test
    public void countTicketNormal2() {
        assertEquals(0, LottoStore.countRandomTicket(14000, 14));
    }

    @Test
    public void countTicketNormal3() {
        assertEquals(14, LottoStore.countRandomTicket(14000, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void countTicketAsManualTicketCountIsTooBig() {
        LottoStore.countRandomTicket(14000, 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void countTicketWithIllegalAmount() {
        LottoStore.countRandomTicket(13500, 10);
    }

    @Test
    public void buyRandomTickets() throws Exception {
        assertEquals(14, LottoStore.buyRandomTickets(14).showTicketMessages().size());
        assertEquals(1, LottoStore.buyRandomTickets(1).showTicketMessages().size());
    }

    @Test
    public void buyExplicitTickets() {
        LottoManualTicketRequest lottoManualTicketRequest = getLottoManualTicketRequest();
        LottoCustomerTicket lottoCustomerTicket = LottoStore.buyExplicitTickets(lottoManualTicketRequest);
        assertEquals(2, lottoCustomerTicket.getTickets().size());
        for (int i = 1; i <= LottoConstants.NUMBER_COUNT; i++) {
            assertTrue(lottoCustomerTicket.getTickets().get(0).match(LottoNumber.of(i)));
        }
    }

    @Test
    public void buyExplicitTicketsAsEmpty() {
        LottoManualTicketRequest lottoManualTicketRequest = new LottoManualTicketRequest("");
        LottoCustomerTicket lottoCustomerTicket = LottoStore.buyExplicitTickets(lottoManualTicketRequest);
        assertTrue(lottoCustomerTicket.getTickets().isEmpty());
    }

    private LottoManualTicketRequest getLottoManualTicketRequest() {
        List<String> ticketRequests = new ArrayList<>();
        ticketRequests.add("1, 2, 3, 4, 5, 6");
        ticketRequests.add("1, 2, 3, 4, 5, 7");
        return new LottoManualTicketRequest(ticketRequests);
    }

    @Test
    public void buyLottoTicket() throws Exception {
        LottoManualTicketRequest lottoManualTicketRequest = getLottoManualTicketRequest();
        LottoCustomerTicket lottoCustomerTicket = LottoStore.buyLottoTicket(14000, lottoManualTicketRequest);
        assertEquals(14, lottoCustomerTicket.getTickets().size());
    }

    @Test
    public void buyLottoTicketWithEmptyManualTicketRequest() throws Exception {
        LottoManualTicketRequest lottoManualTicketRequest = new LottoManualTicketRequest("");
        LottoCustomerTicket lottoCustomerTicket = LottoStore.buyLottoTicket(2000, lottoManualTicketRequest);
        assertEquals(2, lottoCustomerTicket.getTickets().size());
    }
}