package com.woowahan.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoControllerTest {
    private LottoController lottoController;

    @Before
    public void setup() {
        lottoController = new LottoController();
    }

    @Test
    public void 입력금액만큼_로또생성() {
        List<UserLotto> totalLotto = lottoController.buy(14000);
        assertEquals(14, totalLotto.size());
    }

    @Test
    public void 일치번호_개수_구하기() {
        UserLotto lottoNum = new UserLotto(Arrays.asList(
                3, 4, 5, 6, 7, 8
        ));

        List<Integer> luckyNum = Arrays.asList(
                1, 2, 3, 4, 9, 10
        );

        WinningLotto winningLotto = new WinningLotto(luckyNum, 7);

        int corrected = lottoController.check(lottoNum, winningLotto);

        assertEquals(2, corrected);
    }

    @Test
    public void 당첨정보_구하기() {
        List<UserLotto> lottos = Arrays.asList(
                new UserLotto(Arrays.asList(1, 2, 3, 4, 30, 40)),
                new UserLotto(Arrays.asList(1, 3, 4, 9, 13, 20))
        );
        List<Integer> lucky = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(lucky, 7);
        Map<PriceInfo, Integer> luckyInfo = lottoController.checkAllLottos(lottos, winningLotto);
        Map<PriceInfo, Integer> expected = new HashMap<>();
        expected.put(PriceInfo.THREE, 1);
        expected.put(PriceInfo.FOUR, 1);
        expected.put(PriceInfo.FIVE, 0);
        expected.put(PriceInfo.FIVE_BONUS, 0);
        expected.put(PriceInfo.SIX, 0);
        assertEquals(expected, luckyInfo);
    }

    @Test
    public void 전체당첨금액_구하기() {
        Map<PriceInfo, Integer> winInfo = new HashMap<>();
        winInfo.put(PriceInfo.THREE, 1);
        winInfo.put(PriceInfo.FOUR, 1);
        winInfo.put(PriceInfo.FIVE, 0);
        winInfo.put(PriceInfo.FIVE_BONUS, 1);
        winInfo.put(PriceInfo.SIX, 0);
        int totalWinPrice = lottoController.getTotalWinPrice(winInfo);
        assertEquals(30055000, totalWinPrice);
    }

    @Test
    public void 수익률_구하기() {
        int totalWinPrice = 3000000;
        int inputMoney = 30000;

        int expected = lottoController.calculateBenefit(totalWinPrice, inputMoney);

        assertEquals(10000, expected);
    }

}
