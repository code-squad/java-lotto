package com.lotto.utils;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class RandomUtilsTest {

	private Random rnd;

	@Before
	public void setUp() {
		this.rnd = new TestableRandom();
	}

	@Test
	public void 리스트생성_잘되는지() {
		assertEquals(6, RandomUtils.getRandomLottoList(this.rnd).size());
	}

	@Test
	public void 랜덤값_의도대로_생성되는지() {
		assertEquals(2, (int) RandomUtils.getRandomLottoList(this.rnd).get(1));
	}

	class TestableRandom extends Random {
		@Override
		public int nextInt(int bound) {
			return bound;
		}
	}

}
