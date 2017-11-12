package com.lotto.model.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.reflections.Reflections;

import com.google.common.collect.Sets;
import com.lotto.annotation.PurchaseStrategy;
import com.lotto.utils.StringUtils;

public class LottoPurchaseStrategyFactory {
	
	public enum InputTypes {
		AUTO("auto"), MANUAL("manual");
		
		private String msg; 
		
		private InputTypes(String msg) {
			this.msg = msg;
		}
		
		private boolean supports(String input) {
			return this.msg.equalsIgnoreCase(input);
		}
		
		public static InputTypes value(String input) {
			return Arrays.asList(InputTypes.values()).stream().filter(e -> e.supports(input))
					.findFirst().get();
		}
		
		public String getValue() {
			return this.msg;
		}
	}
	
	private static final LottoPurchaseStrategyFactory lpsf = new LottoPurchaseStrategyFactory();
	private Set<LottoPurchaseStrategy> strategyImpls = Sets.newHashSet();
	
	private LottoPurchaseStrategyFactory() {}
	
	public static LottoPurchaseStrategyFactory getInstance() {
		return lpsf;
	}
	
	
	public void initialize() {
		Reflections reflections = new Reflections("com.lotto.model.strategy");
		reflections.getTypesAnnotatedWith(PurchaseStrategy.class).stream().forEach(c -> {
			try {
				this.strategyImpls.add((LottoPurchaseStrategy)c.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}
	
	public LottoPurchaseStrategy getPurchaseStrategy(String input) {
		return this.strategyImpls.stream().filter(s -> s.supports(InputTypes.value(input)))
		.findFirst().get();
	}
	
	public static LottoPurchaseStrategy getTestableImpl() {
		return new LottoPurchaseStrategy() {

			@Override
			public List<Integer> selectNumbers(Scanner scn) {
				return StringUtils.makeNumListFromString(scn.nextLine());
			}

			@Override
			public boolean supports(InputTypes type) {
				return false;
			}
			
		};
	}

}
