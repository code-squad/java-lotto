package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WinningLottoTest {
    @Test
    public void isMatchedBonus() throws Exception {
        WinningLotto winningLotto =
                new WinningLotto(
                        LottoNo.getLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new LottoNo(7));
        LottoTicket lottoTicket = new LottoTicket(LottoNo.getLottoNos(Arrays.asList(1,2,3,4,5,7)));
        assertEquals(true, winningLotto.isMatchedBonus(lottoTicket));
    }

    @Test
    public void match() throws Exception {
        List<LottoNo> numbers = LottoNo.getLottoNos(Arrays.asList(1,2,3,4,5,6));
        LottoNo bonus = new LottoNo(7);
        WinningLotto winningLotto = new WinningLotto(numbers, bonus);
        LottoTicket lottoTicket = new LottoTicket(LottoNo.getLottoNos(Arrays.asList(1,2,3,8,9,10)));

        assertEquals(Rank.FIFTH, winningLotto.match(lottoTicket));
    }
}
