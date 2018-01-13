package lotto;

import lotto.domain.CustomerLottoTickets;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LottoOperatorTest {
    private LottoOperator lottoOperator;

    @Before
    public void setUp() throws Exception {
        lottoOperator = new LottoOperator("1, 2, 3, 4, 5, 6");
    }

    @Test
    public void putLastWeekSuccessNumber() {
        List<Integer> lottoNumbers = lottoOperator.getSuccessNumbers();
        assertTrue(lottoNumbers.contains(1));
        assertTrue(lottoNumbers.contains(2));
        assertTrue(lottoNumbers.contains(3));
        assertTrue(lottoNumbers.contains(4));
        assertTrue(lottoNumbers.contains(5));
        assertTrue(lottoNumbers.contains(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void putLastWeekSuccessNumberWithIllegalArgument() {
        new LottoOperator("1, 2, 3, 4, 5");
    }

    @Test
    public void matchTickets() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 7, 8, 9"));

        CustomerLottoTickets customerLottoTickets = new CustomerLottoTickets(lottoTickets);

        int ticketTotalPrice = 2000;

        LottoResult lottoResult = lottoOperator.match(customerLottoTickets, ticketTotalPrice);
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.NONE));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.THREE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FOUR));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.SIX));

        assertEquals(LottoPrize.THREE.getPrizeAmount() * 100 / ticketTotalPrice, lottoResult.calculateProfitRatio());
    }

    @Test
    public void check0Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9");
        assertEquals(LottoPrize.NONE, lottoOperator.match(lottoTicket));
    }

    @Test
    public void check1Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 10, 11, 7, 8, 9");
        assertEquals(LottoPrize.NONE, lottoOperator.match(lottoTicket));
    }

    @Test
    public void check2Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 10, 7, 8, 9");
        assertEquals(LottoPrize.NONE, lottoOperator.match(lottoTicket));
    }

    @Test
    public void check3Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 7, 8, 9");
        assertEquals(LottoPrize.THREE, lottoOperator.match(lottoTicket));
    }

    @Test
    public void check4Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 8, 9");
        assertEquals(LottoPrize.FOUR, lottoOperator.match(lottoTicket));
    }

    @Test
    public void check5Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 9");
        assertEquals(LottoPrize.FIVE, lottoOperator.match(lottoTicket));
    }

    @Test
    public void check6Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 6");
        assertEquals(LottoPrize.SIX, lottoOperator.match(lottoTicket));
    }
}
