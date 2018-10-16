package com.zingoworks.lotto.domain;

/*
Test the program before you write it.
Clean code that works.

Lotteries Class 테스트
1. 구매금액 / 게임당가격 만큼 Lottery 생성
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EveryLotteryTest {

    @Test
    public void testEveryLottoTest() {
//        Lotteries el = new Lotteries(1000);
    }

    @Test
    public void testGenerateEveryLottoSet() throws Exception {
        assertEquals(Lotteries.getAllLotteries(5000).size(), 5);
        assertEquals(Lotteries.getAllLotteries(10000).size(), 10);
        assertEquals(Lotteries.getAllLotteries(0).size(), 0);
        assertEquals(Lotteries.getAllLotteries(2500).size(), 2);
    }
}
