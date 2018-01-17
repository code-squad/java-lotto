package com.woowahan.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class lottoTest {
    private Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    public void 랜덤숫자사이즈확인() {
        List<Integer> numberList = lotto.create();
        assertEquals(6, numberList.size());
    }

    @Test
    public void 입력금액만큼로또생성() {
        List<List<Integer>> totalLotto = lotto.buyLotto(14000);
        assertEquals(14, totalLotto.size());
    }

}
