package lotto.domain;

import lotto.LottoStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerLottoTicketsTest {
    @Test
    public void count() throws Exception {
        CustomerLottoTickets customerLottoTickets = LottoStore.buyRandomTickets(10);
        assertEquals(10, customerLottoTickets.count());
    }

}