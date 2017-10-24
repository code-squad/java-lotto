package lotto.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WinPriceTest {

	private WinPrice winPrice = new WinPrice();

	@Test
	public void testAddWinPrice() {
		winPrice.addWinPrice(3, 5000);
		winPrice.addWinPrice(4, 50000);
		winPrice.addWinPrice(5, 1500000);
		winPrice.addWinPrice(6, 2000000000);
	}

	@Test
	public void testAddMatchCount() {
		testAddWinPrice();
		winPrice.addMatchCount(3);
		winPrice.addMatchCount(3);
		winPrice.addMatchCount(5);
		winPrice.addMatchCount(5);
	}

	@Test
	public void testGetMatchSumPrice() {
		testAddWinPrice();
		testAddMatchCount();
		assertEquals(winPrice.getMatchSumPrice(3), 10000);
		assertEquals(winPrice.getMatchSumPrice(5), 3000000);
	}

	@Test
	public void testGetTotalSumPrice() {
		testAddWinPrice();
		testAddMatchCount();
		assertEquals(winPrice.getTotalSumPrice(), 3010000);
	}
}
