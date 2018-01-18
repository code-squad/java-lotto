package com.woowahan.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoTest {
    Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    public void 랜덤_숫자_사이즈_확인() {
        assertEquals(6, lotto.getLotto().size());
    }

    @Test
    public void 로또번호_오름차순으로_정렬() {
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
}
