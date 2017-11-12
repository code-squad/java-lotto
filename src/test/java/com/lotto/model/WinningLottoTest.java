package com.lotto.model;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.lotto.model.WinningLotto.Prizes;
import com.lotto.model.strategy.LottoPurchaseStrategyFactory;
import com.lotto.model.strategy.NumberGenerateStrategy;
import com.lotto.model.strategy.NumberGenerateStrategyFactory.GenerateTypes;

public class WinningLottoTest {

	private WinningLotto wl;
	private UserLotto ul;

	@Before
	public void setUp() {
		this.wl = new WinningLotto(new NumberGenerateStrategy() {

			@Override
			public List<Integer> generateBalls() {
				return Arrays.asList(1, 2, 3, 4, 5, 6);
			}

			@Override
			public boolean supports(GenerateTypes type) {
				return false;
			}

			@Override
			public int generateBonusBall() {
				return 7;
			}

		});
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream("1 2 3 4 5 7".getBytes()));
		Scanner scanner = new Scanner(System.in);
		System.setIn(stdin);
		this.ul = new UserLotto(LottoPurchaseStrategyFactory.getTestableImpl(), scanner);
	}

	@Test
	public void 일치숫자_갯수_확인() {
		wl.setWinningNumbers();
		ul.setNumbers();
		assertTrue(Prizes.MATCH_BONUS == wl.getMatchingResult(this.ul));
	}

}
