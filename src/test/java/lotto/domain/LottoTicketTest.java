package lotto.domain;

import lotto.LottoStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoTicketTest {
    @Test
    public void match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 6");
        assertTrue(lottoTicket.match(LottoNumber.newInstance(1)));
        assertTrue(lottoTicket.match(LottoNumber.newInstance(2)));
        assertTrue(lottoTicket.match(LottoNumber.newInstance(3)));
        assertTrue(lottoTicket.match(LottoNumber.newInstance(4)));
        assertTrue(lottoTicket.match(LottoNumber.newInstance(5)));
        assertTrue(lottoTicket.match(LottoNumber.newInstance(6)));
    }

    @Test
    public void testToString() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("42, 8, 21, 43, 23, 41");
        assertEquals("[8, 21, 23, 41, 42, 43]", lottoTicket.toString());
    }
}