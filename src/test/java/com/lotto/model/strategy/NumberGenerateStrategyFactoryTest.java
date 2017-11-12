package com.lotto.model.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberGenerateStrategyFactoryTest {
	
	private NumberGenerateStrategyFactory ngsf = NumberGenerateStrategyFactory.getInstance();
	
	@Before
	public void setUp() {
		this.ngsf.initialize();
	}
	
	@Test
	public void 이넘밸류_메소드_작동하는지() {
		assertTrue(NumberGenerateStrategyFactory.GenerateTypes.AUTO == NumberGenerateStrategyFactory.GenerateTypes.values("auto"));
	}

	@Test
	public void 구현체_리턴_작동하는지() {
		assertTrue(this.ngsf.getStrategy("auto") instanceof AutoWinningNumberStrategy);
	}

}
