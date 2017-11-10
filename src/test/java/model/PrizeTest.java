package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrizeTest {

	@Test
	public void second() {
		assertEquals(Prize.SECOND, Prize.valueOf(5, true));
	}
	@Test
	public void third() {
		assertEquals(Prize.THIRD, Prize.valueOf(5, false));
	}
	@Test
	public void first() {
		assertEquals(Prize.FIRST, Prize.valueOf(6, false));
		assertEquals(Prize.FIRST, Prize.valueOf(6, true));
	}
	@Test
	public void fourth() {
		assertEquals(Prize.FOURTH, Prize.valueOf(4, true));
	}

}
