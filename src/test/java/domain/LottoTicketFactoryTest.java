package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoTicketFactoryTest {
    @Test
    public void generateLottoTicket() {
        LottoTicket lottoTicket = LottoTicketFactory.getLottoTicket();
        assertEquals(6, lottoTicket.getNumbers().size());
    }
}
