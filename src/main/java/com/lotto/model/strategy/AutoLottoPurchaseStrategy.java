package com.lotto.model.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lotto.annotation.PurchaseStrategy;
import com.lotto.model.strategy.LottoPurchaseStrategyFactory.InputTypes;
import com.lotto.utils.RandomUtils;

@PurchaseStrategy
public class AutoLottoPurchaseStrategy implements LottoPurchaseStrategy{

	@Override
	public List<Integer> selectNumbers(Scanner scn) {
		List<Integer> returnList = RandomUtils.getRandomLottoList(new Random());
		Collections.sort(returnList);
		System.out.println("자동선택 번호 : " + returnList);
		return returnList;
	}

	@Override
	public boolean supports(InputTypes type) {
		return InputTypes.AUTO == type;
	}

}
