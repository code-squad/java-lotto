package com.lotto.model.strategy;

import java.util.List;

import com.lotto.model.strategy.NumberGenerateStrategyFactory.GenerateTypes;

public interface NumberGenerateStrategy {
	public List<Integer> generateBalls();
	public int generateBonusBall();
	
	public boolean supports(GenerateTypes type); 
}
