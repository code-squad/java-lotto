package com.lotto.model.strategy;

import java.util.Arrays;
import java.util.Set;

import org.reflections.Reflections;

import com.google.common.collect.Sets;
import com.lotto.annotation.GenerateStrategy;
import com.lotto.exceptions.InvalidTypeOperationException;

public class NumberGenerateStrategyFactory {

	private Set<NumberGenerateStrategy> ngsImpls = Sets.newHashSet();

	public enum GenerateTypes {
		AUTO("auto"), MANUAL("manual");

		private String msg;

		private GenerateTypes(String msg) {
			this.msg = msg;
		}

		private boolean supports(String msg) {
			return this.msg.equalsIgnoreCase(msg);
		}

		public static GenerateTypes values(String msg) {
			return Arrays.asList(GenerateTypes.values()).stream().filter(v -> v.supports(msg)).findFirst()
					.orElseThrow(() -> new InvalidTypeOperationException("지원하지 않는 타입 호출입니다."));
		}
	}

	private static final NumberGenerateStrategyFactory ngsf = new NumberGenerateStrategyFactory();

	private NumberGenerateStrategyFactory() {
	}

	public static NumberGenerateStrategyFactory getInstance() {
		return ngsf;
	}

	public void initialize() {
		Reflections reflections = new Reflections("com.lotto.model.strategy");
		reflections.getTypesAnnotatedWith(GenerateStrategy.class).stream().forEach(c -> {
			try {
				this.ngsImpls.add((NumberGenerateStrategy) c.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}

	public NumberGenerateStrategy getStrategy(String input) {
		return this.ngsImpls.stream().filter(n -> n.supports(GenerateTypes.values(input))).findFirst()
				.orElseThrow(() -> new InvalidTypeOperationException("지원하지 않는 타입입니다."));
	}
}
