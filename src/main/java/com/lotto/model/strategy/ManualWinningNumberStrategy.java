package com.lotto.model.strategy;

import java.util.List;
import java.util.Scanner;

import com.lotto.annotation.GenerateStrategy;
import com.lotto.model.strategy.NumberGenerateStrategyFactory.GenerateTypes;
import com.lotto.utils.StringUtils;
import com.lotto.view.ConsoleMessages;

@GenerateStrategy
public class ManualWinningNumberStrategy implements NumberGenerateStrategy {

	@Override
	public List<Integer> generateBalls() {
		Scanner scn = new Scanner(System.in);
		System.out.println(ConsoleMessages.INPUT_PROMPT_WINNINGNUMBERS);
		System.out.println();

		return StringUtils.makeNumListFromString(scn.nextLine());

	}

	@Override
	public int generateBonusBall() {
		Scanner scn = new Scanner(System.in);
		System.out.println(ConsoleMessages.INPUT_PROMPT_BONUS);
		System.out.println();
		return scn.nextInt();
	}

	@Override
	public boolean supports(GenerateTypes type) {
		return GenerateTypes.MANUAL == type;
	}

}
