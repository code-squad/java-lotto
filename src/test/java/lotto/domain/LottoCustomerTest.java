package lotto.domain;

import lotto.LottoStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoCustomerTest {
    @Test
    public void showCountMessage() throws Exception {
        int ticketCount = 10;
        LottoCustomer lottoCustomer = LottoStore.buyRandomTickets(ticketCount);
        assertEquals(ticketCount + "개를 구매했습니다.", lottoCustomer.showCountMessage());
    }

}