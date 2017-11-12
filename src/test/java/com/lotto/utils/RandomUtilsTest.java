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
		assertEquals(6, RandomUtils.getRandomLottoList(this.rnd).size());
	}

	@Test
	public void 랜덤값_의도대로_생성되는지() {
		List<Integer> numbers = RandomUtils.getRandomLottoListByStream(new Random());
		logger.debug(numbers.toString());
		assertEquals(6, numbers.size());
	}


	class TestableRandom extends Random {
		@Override
		public int nextInt(int bound) {
			return bound;
		}
	}

}
