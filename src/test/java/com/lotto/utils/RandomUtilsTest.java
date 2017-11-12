package com.lotto.utils;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomUtilsTest {

	private Random rnd;
	private static final Logger logger = LoggerFactory.getLogger(RandomUtilsTest.class);


	@Before
	public void setUp() {
		this.rnd = new TestableRandom();
	}

	@Test
	public void 리스트생성_잘되는지() {
		assertEquals(6, RandomUtils.getRandomLottoList(new Random()).size());
	}

	class TestableRandom extends Random {
		@Override
		public int nextInt(int bound) {
			return bound;
		}
	}

}
