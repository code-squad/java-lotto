package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	private Set<String> defaultDelimiters;
	private static final String FORMULA_REGEX = "//(.)\n(.*)";
	
	public StringCalculator(String... defaultDelimiters) {
		this.defaultDelimiters = new HashSet<>(Arrays.asList(defaultDelimiters));
	}
	
	public int calculate(String formula) {
		if(isEmptyFormula(formula)) {
			return 0;
		}
		
		return sum(getOperands(formula, getDelimiters(getCustomDelimiter(formula))));
	}
	
	private static boolean isEmptyFormula(String s) {
		if(s == null || s.isEmpty()) {
			return true;
		}
		return false;
	}
	
	private String getCustomDelimiter(String formula) {
		Matcher matcher = getMatcherCustomFormula(formula);
		if(!matcher.find()) {
			return null;
		}
		return matcher.group(1);
	}
	
	private Matcher getMatcherCustomFormula(String formula) {
		return Pattern.compile(FORMULA_REGEX).matcher(formula);
	}
	
	private Set<String> getDelimiters(String customDelimiter) {
		if(customDelimiter == null) {
			return defaultDelimiters;
		}
		
		Set<String> delimiters = new HashSet<>(defaultDelimiters);
		delimiters.add(customDelimiter);
		return delimiters;
	}
	
	private int[] getOperands(String formula, Set<String> delimiters) {
		Matcher matcher = getMatcherCustomFormula(formula);
		if(matcher.find()) {
			formula = matcher.group(2);
		}
		
		String regex  = delimiters.stream()
				.collect(Collectors.joining("|"));
		return Arrays.stream(formula.split(regex))
				.mapToInt(this::changeIntegerOperand)
				.toArray();
	}
	
	private int changeIntegerOperand(String operand) {
		int integerOperand = Integer.parseInt(operand);
		validateOperand(integerOperand);
		return integerOperand;
	}
	
	private void validateOperand(int integerOperand) {
		if(integerOperand < 0) {
			throw new RuntimeException("음수가 입력되었습니다.");
		}
	}
	
	private int sum(int[] operands) {
		return Arrays.stream(operands)
				.sum();
	}
}