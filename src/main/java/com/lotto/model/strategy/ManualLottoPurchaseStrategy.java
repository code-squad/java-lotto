package com.lotto.model.strategy;

import java.util.List;
import java.util.Scanner;

import com.lotto.annotation.PurchaseStrategy;
import com.lotto.model.strategy.LottoPurchaseStrategyFactory.InputTypes;
import com.lotto.utils.StringUtils;
import com.lotto.view.ConsoleMessages;

@PurchaseStrategy
public class ManualLottoPurchaseStrategy implements LottoPurchaseStrategy{

	@Override
	public List<Integer> selectNumbers(Scanner scn) {
		System.out.println(ConsoleMessages.INPUT_PROMPT_NUMBERS);
		return StringUtils.makeNumListFromString(scn.nextLine());
	}

	@Override
	public boolean supports(InputTypes type) {
		return InputTypes.MANUAL == type;
	}

}
