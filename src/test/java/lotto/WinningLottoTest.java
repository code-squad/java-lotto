package lotto;

import lotto.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class WinningLottoTest {
    private WinningLotto winningLotto;

    @Before
    public void setUp() throws Exception {
        winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "7");
    }

    @Test
    public void putLastWeekSuccessNumber() {
        List<LottoNumber> lottoNumbers = winningLotto.getSuccessNumbers();
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(1)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(2)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(3)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(4)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(5)));
        assertTrue(lottoNumbers.contains(LottoNumber.newInstance(6)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void putLastWeekSuccessNumberWithIllegalArgument() {
        new WinningLotto("1, 2, 3, 4, 5", "7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void putLastWeekSuccessNumberWithIllegalArgumentOverflow() {
        new WinningLotto("1, 2, 3, 4, 5, 46", "7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void putLastWeekSuccessNumberWithIllegalArgumentUnderflow() {
        new WinningLotto("0, 2, 3, 4, 5, 6", "7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void putLastWeekSuccessNumberWithBonusDuplicated() {
        new WinningLotto("1, 2, 3, 4, 5, 6", "6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void putLastWeekSuccessNumberWithNormalDuplicated() {
        new WinningLotto("1, 2, 3, 4, 6, 6", "7");
    }

    @Test
    public void matchTickets() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 7, 8, 9"));

        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(lottoTickets);

        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.NONE));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.THREE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FOUR));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE_BONUS));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.SIX));

        assertEquals(250, lottoResult.calculateProfitRatio());
    }

    @Test
    public void matchTicketsWithNothing() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9"));

        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(lottoTickets);

        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.NONE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.THREE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FOUR));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE_BONUS));

        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.SIX));

        assertEquals(-100, lottoResult.calculateProfitRatio());
    }

    @Test
    public void matchTicketsWithNoProfit() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 7, 8, 9"));
        lottoTickets.add(LottoStore.buyExplicitTicket("7, 8, 9, 45, 43, 23"));
        lottoTickets.add(LottoStore.buyExplicitTicket("7, 8, 9, 13, 12, 11"));
        lottoTickets.add(LottoStore.buyExplicitTicket("7, 8, 9, 23, 42, 31"));
        lottoTickets.add(LottoStore.buyExplicitTicket("7, 8, 1, 23, 42, 31"));

        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(lottoTickets);

        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);
        assertEquals(5, lottoResult.getPrizeCount(LottoPrize.NONE));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.THREE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FOUR));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE_BONUS));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.SIX));

        assertEquals(-17, lottoResult.calculateProfitRatio());
    }


    @Test
    public void matchTicketsWithBonus() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 7"));

        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(lottoTickets);

        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.NONE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.THREE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FOUR));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FIVE));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.FIVE_BONUS));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.SIX));

        assertEquals(3000000, lottoResult.calculateProfitRatio());
    }

    @Test
    public void matchTicketsWithFirstPrize() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 6"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 8"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 7"));

        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(lottoTickets);

        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.NONE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.THREE));
        assertEquals(0, lottoResult.getPrizeCount(LottoPrize.FOUR));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.FIVE));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.FIVE_BONUS));
        assertEquals(1, lottoResult.getPrizeCount(LottoPrize.SIX));

        assertEquals(67716666, lottoResult.calculateProfitRatio());
    }

    @Test
    public void check0Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9");
        assertEquals(LottoPrize.NONE, winningLotto.match(lottoTicket));
    }

    @Test
    public void check1Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 10, 11, 7, 8, 9");
        assertEquals(LottoPrize.NONE, winningLotto.match(lottoTicket));
    }

    @Test
    public void check2Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 10, 7, 8, 9");
        assertEquals(LottoPrize.NONE, winningLotto.match(lottoTicket));
    }

    @Test
    public void check3Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 7, 8, 9");
        assertEquals(LottoPrize.THREE, winningLotto.match(lottoTicket));
    }

    @Test
    public void check4Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 8, 9");
        assertEquals(LottoPrize.FOUR, winningLotto.match(lottoTicket));
    }

    @Test
    public void check5Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 9");
        assertEquals(LottoPrize.FIVE, winningLotto.match(lottoTicket));
    }

    @Test
    public void check6Match() throws Exception {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 6");
        assertEquals(LottoPrize.SIX, winningLotto.match(lottoTicket));
    }
}
