package com.lotto.model.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.lotto.annotation.GenerateStrategy;
import com.lotto.model.strategy.NumberGenerateStrategyFactory.GenerateTypes;
import com.lotto.utils.RandomUtils;

@GenerateStrategy
public class AutoWinningNumberStrategy implements NumberGenerateStrategy{

	@Override
	public List<Integer> generateBalls() {
		List<Integer> winningBalls = RandomUtils.getRandomLottoList(new Random());
		Collections.sort(winningBalls);
		System.out.println("추첨된 당첨 번호 : " + winningBalls);
		return winningBalls;
	}

	@Override
	public int generateBonusBall() {
		int bonus = RandomUtils.getRandomBonusBall(new Random());
		System.out.println("추첨된 보너스 번호 : " + bonus);
		return bonus;
	}

	@Override
	public boolean supports(GenerateTypes type) {
		return GenerateTypes.AUTO == type;
	}

}
