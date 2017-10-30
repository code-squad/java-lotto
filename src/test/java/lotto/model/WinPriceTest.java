package lotto.model;

import static org.junit.Assert.*;

import org.junit.Test;

import lotto.model.WinPrice.WinValue;

public class WinPriceTest {

	@Test
	public void testWinValue() {
		WinPrice winPrice = new WinPrice();
		assertEquals(WinValue.FIFTH, winPrice.valueOf(3, false));
		assertEquals(WinValue.FOURTH, winPrice.valueOf(4, false));
		assertEquals(WinValue.THIRD, winPrice.valueOf(5, false));
		assertEquals(WinValue.SECOND, winPrice.valueOf(5, true));
		assertEquals(WinValue.FIRST, winPrice.valueOf(6, false));

		assertEquals(WinValue.FIFTH.getPrice(), 5000);
	}

	@Test
	public void testGetTotalSumPrice() {
		WinPrice winPrice = new WinPrice();
		winPrice.addMatchCount(3, false);
		winPrice.addMatchCount(3, false);

		winPrice.addMatchCount(4, false);
		winPrice.addMatchCount(4, false);
		winPrice.addMatchCount(5, true);
		winPrice.addMatchCount(5, false);

		int totalSumPrice = winPrice.getSumPrice(WinValue.FIFTH);
		totalSumPrice += winPrice.getSumPrice(WinValue.FOURTH);
		totalSumPrice += winPrice.getSumPrice(WinValue.SECOND);
		totalSumPrice += winPrice.getSumPrice(WinValue.THIRD);

		assertEquals(winPrice.getTotalSumPrice(), totalSumPrice);
	}
}