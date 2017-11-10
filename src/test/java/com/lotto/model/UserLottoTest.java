package com.lotto.model;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.lotto.model.strategy.LottoPurchaseStrategyFactory;

public class UserLottoTest {

	UserLotto ul;

	@Before
	public void setUp() {
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream("1 2 3 4 5 6".getBytes()));
		Scanner scanner = new Scanner(System.in);
		System.setIn(stdin);
		this.ul = new UserLotto(LottoPurchaseStrategyFactory.getTestableImpl(), scanner);
	}

	@Test
	public void 스캐너_받아서_숫자리스트_만들기() {
		ul.setNumbers();
		assertEquals(6, ul.getNumbers().size());
	}
}
