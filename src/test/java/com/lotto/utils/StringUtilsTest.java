package com.lotto.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void test() {
		assertEquals(6, StringUtils.makeNumListFromString("1 2 3 4 5 6").size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void 예외처리_잘되는지() {
		StringUtils.makeNumListFromString("0 1 2 3 4 5");
	}

}
