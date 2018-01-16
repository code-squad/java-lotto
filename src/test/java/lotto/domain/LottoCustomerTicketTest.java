package lotto.domain;

import lotto.LottoStore;
import org.junit.Test;

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

}