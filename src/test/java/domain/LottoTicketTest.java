package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LottoTicketTest {
    @Test
    public void getMatchedCountPass() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1,2,3,7,8,9));
        assertEquals(3, lottoTicket.getMatchedCount(winningLottoTicket));
    }
}
