package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoTicketTest {
    @Test
    public void getMatchedCountPass() {
        LottoTicket lottoTicket = new LottoTicket(LottoNo.getLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(
                LottoNo.getLottoNos(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new LottoNo(10));
        assertEquals(3, winningLotto.getMatchedNo(lottoTicket));
    }
}
