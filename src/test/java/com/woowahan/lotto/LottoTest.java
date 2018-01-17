package com.woowahan.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    public void 랜덤_숫자_사이즈_확인() {
        List<Integer> numberList = lotto.create();
        assertEquals(6, numberList.size());
    }

    @Test
    public void 입력금액만큼_로또생성() {
        List<List<Integer>> totalLotto = lotto.buy(14000);
        assertEquals(14, totalLotto.size());
    }

    @Test
    public void 로또번호_오름차순으로_정렬() {
        List<Integer> sortedList = lotto.sort(Arrays.asList(
                30, 13, 24, 15, 6, 41
        ));

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
        List<Integer> lottoNum = Arrays.asList(
                3, 4, 5, 6, 7, 8
        );

        List<Integer> luckyNum = Arrays.asList(
                1, 2, 3, 4, 9, 10
        );

        int corrected = lotto.check(lottoNum, luckyNum);

        assertEquals(2, corrected);
    }

    @Test
    public void 당첨정보_구하기() {
        List<List<Integer>> lottos = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 30, 40),
                Arrays.asList(1, 3, 4, 9, 13, 20)
        );
        List<Integer> lucky = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Integer, Integer> luckyInfo = lotto.getWinInfo(lottos, lucky);
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
        int totalWinPrice = lotto.getTotalWinPrice(winInfo);
        assertEquals(55000, totalWinPrice);
    }

}
