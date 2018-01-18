package lotto.domain;

import lotto.LottoStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LottoCustomerTicketTest {
    @Test
    public void showCountMessage() throws Exception {
        int ticketCount = 10;
        int explicitTicketCount = 4;
        int randomTicketCount = ticketCount - explicitTicketCount;
        LottoCustomerTicket randomTickets = LottoStore.buyRandomTickets(randomTicketCount);
        LottoCustomerTicket explicitTickets = LottoStore.buyRandomTickets(explicitTicketCount);

        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(randomTickets, explicitTickets);
        assertEquals("수동으로 " + explicitTicketCount + "장, 자동으로 " + randomTicketCount + "장을 구매했습니다."
                , lottoCustomerTicket.showCountMessage());
    }

    @Test
    public void testToString() {
        String ticket1 = "1, 2, 3, 4, 5, 6";
        String ticket2 = "31, 32, 33, 34, 35, 36";
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoStore.buyExplicitTicket(ticket1));
        tickets.add(LottoStore.buyExplicitTicket(ticket2));
        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(tickets);

        assertEquals(ticket1 + LottoConstants.NEW_LINE + ticket2 + LottoConstants.NEW_LINE, lottoCustomerTicket.toString());
    }

}