package lotto;

import lotto.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (int i = 1; i <= LottoConstants.NUMBER_COUNT; i++) {
            assertTrue(lottoNumbers.contains(LottoNumber.of(i)));
        }
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

        Map<LottoPrize, Integer> prizes = new HashMap<>();
        prizes.put(LottoPrize.NONE, 1);
        prizes.put(LottoPrize.THREE, 1);

        matchTickets(lottoTickets, prizes, 250);
    }

    private void matchTickets(List<LottoTicket> lottoTickets, Map<LottoPrize, Integer> prizes, int calculatedProfitRatio) {
        LottoCustomerTicket lottoCustomerTicket = new LottoCustomerTicket(lottoTickets);
        LottoResult lottoResult = lottoCustomerTicket.matchTickets(winningLotto);

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            // try to use 'getOrDefault' method ?! instead of below code.
            // int count = (prizes.containsKey(lottoPrize)) ? prizes.get(lottoPrize) : 0;
            int count = prizes.getOrDefault(lottoPrize, 0);
            assertEquals(count, lottoResult.getPrizeCount(lottoPrize));
        }
        assertEquals(calculatedProfitRatio, lottoResult.calculateProfitRatio());
    }

    @Test
    public void matchTicketsWithNothing() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("10, 11, 12, 7, 8, 9"));

        Map<LottoPrize, Integer> prizes = new HashMap<>();
        prizes.put(LottoPrize.NONE, 1);

        matchTickets(lottoTickets, prizes, -100);
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

        Map<LottoPrize, Integer> prizes = new HashMap<>();
        prizes.put(LottoPrize.NONE, 5);
        prizes.put(LottoPrize.THREE, 1);

        matchTickets(lottoTickets, prizes, -17);
    }


    @Test
    public void matchTicketsWithBonus() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 7"));

        Map<LottoPrize, Integer> prizes = new HashMap<>();
        prizes.put(LottoPrize.FIVE_BONUS, 1);

        matchTickets(lottoTickets, prizes, 3000000);
    }

    @Test
    public void matchTicketsWithFirstPrize() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 6"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 8"));
        lottoTickets.add(LottoStore.buyExplicitTicket("1, 2, 3, 4, 5, 7"));

        Map<LottoPrize, Integer> prizes = new HashMap<>();
        prizes.put(LottoPrize.FIVE, 1);
        prizes.put(LottoPrize.FIVE_BONUS, 1);
        prizes.put(LottoPrize.SIX, 1);

        matchTickets(lottoTickets, prizes, 67716666);
    }

    @Test
    public void check0Match() throws Exception {
        checkMatch(LottoPrize.NONE, "10, 11, 12, 7, 8, 9");
    }

    private void checkMatch(LottoPrize lottoPrize, String ticketNumberString) {
        LottoTicket lottoTicket = LottoStore.buyExplicitTicket(ticketNumberString);
        assertEquals(lottoPrize, winningLotto.match(lottoTicket));
    }

    @Test
    public void check1Match() throws Exception {
        checkMatch(LottoPrize.NONE,"1, 10, 11, 7, 8, 9");
    }

    @Test
    public void check2Match() throws Exception {
        checkMatch(LottoPrize.NONE,"1, 2, 10, 7, 8, 9");
    }

    @Test
    public void check3Match() throws Exception {
        checkMatch(LottoPrize.THREE,"1, 2, 3, 7, 8, 9");
    }

    @Test
    public void check4Match() throws Exception {
        checkMatch(LottoPrize.FOUR,"1, 2, 3, 4, 8, 9");
    }

    @Test
    public void check5Match() throws Exception {
        checkMatch(LottoPrize.FIVE,"1, 2, 3, 4, 5, 9");
    }

    @Test
    public void check6Match() throws Exception {
        checkMatch(LottoPrize.SIX,"1, 2, 3, 4, 5, 6");
    }
}
