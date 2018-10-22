package com.zingoworks.lotto.domain;

/*
Test the program before you write it.
Clean code that works.

Lottos Class 테스트
1. 구매금액 / 게임당가격 만큼 Lotto 생성
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EveryLottoTest {


    @Test
    public void 모든로또생성() throws Exception {
        assertEquals(Lottos.getAllLottos(5000).size(), 5);
        assertEquals(Lottos.getAllLottos(10000).size(), 10);
        assertEquals(Lottos.getAllLottos(0).size(), 0);
        assertEquals(Lottos.getAllLottos(2500).size(), 2);
    }
}
