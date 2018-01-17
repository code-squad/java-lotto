package com.woowahan.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

}
