package com.jiwon.lotto.winstats;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinStatsTest {

	@Test
	public void totalMoney() {
		assertEquals("총 수익률은 200%입니다.", WinStats.calculateTotalProfit(10000, 20000));
	}

}
