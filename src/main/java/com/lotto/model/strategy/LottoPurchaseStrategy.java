package com.lotto.model.strategy;

import java.util.List;
import java.util.Scanner;

import com.lotto.model.strategy.LottoPurchaseStrategyFactory.InputTypes;

public interface LottoPurchaseStrategy {

	public List<Integer> selectNumbers(Scanner scn);
	
	public boolean supports(InputTypes type);

}
