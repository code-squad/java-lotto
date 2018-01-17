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
    public void 랜덤_숫자_사이즈_확인() {
        Lotto lotto = new Lotto();

        assertEquals(6, lotto.getLotto().size());
    }

    @Test
    public void 입력금액만큼_로또생성() {
        List<Lotto> totalLotto = lottoController.buy(14000);
        assertEquals(14, totalLotto.size());
    }

    @Test
    public void 로또번호_오름차순으로_정렬() {
        Lotto lotto = new Lotto();

        List<Integer> sortedList = lotto.sort(lotto.getLotto());

        boolean isSorted = true;

        for (int i = 0; i < sortedList.size() - 1; i++) {
            if (sortedList.get(i) > sortedList.get(i + 1)) {
                isSorted = false;
                break;
            }
        }

        assertTrue(isSorted);
    }

    @Test
    public void 일치번호_개수_구하기() {
        Lotto lottoNum = new Lotto(Arrays.asList(
                3, 4, 5, 6, 7, 8
        ));

        List<Integer> luckyNum = Arrays.asList(
                1, 2, 3, 4, 9, 10
        );

        int corrected = lottoController.check(lottoNum, luckyNum);

        assertEquals(2, corrected);
    }

    @Test
    public void 당첨정보_구하기() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 30, 40)),
                new Lotto(Arrays.asList(1, 3, 4, 9, 13, 20))
        );
        List<Integer> lucky = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Integer, Integer> luckyInfo = lottoController.getWinInfo(lottos, lucky);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(5000, 1);
        expected.put(50000, 1);
        expected.put(1500000, 0);
        expected.put(2000000000, 0);
        assertEquals(expected, luckyInfo);
    }

    @Test
    public void 전체당첨금액_구하기() {
        Map<Integer, Integer> winInfo = new HashMap<>();
        winInfo.put(5000, 1);
        winInfo.put(50000, 1);
        winInfo.put(1500000, 0);
        winInfo.put(2000000000, 0);
        int totalWinPrice = lottoController.getTotalWinPrice(winInfo);
        assertEquals(55000, totalWinPrice);
    }

}
