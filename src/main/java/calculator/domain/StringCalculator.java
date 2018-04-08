package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	private Delimiters defaultDelimiters;
	private static final String FORMULA_REGEX = "//(.)\n(.*)";
	
	public StringCalculator(String... defaultDelimiters) {
		this.defaultDelimiters = new Delimiters(defaultDelimiters);
	}
	
	public int calculate(String formula) {
		if(isEmptyFormula(formula)) {
			return 0;
		}
		
		return sum(getOperands(getPureFormula(formula), getDelimiters(getCustomDelimiter(formula))));
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
	
	private Delimiters getDelimiters(String customDelimiter) {
		if(customDelimiter == null) {
			return defaultDelimiters;
		}
		
		return defaultDelimiters.clone(customDelimiter);
	}
	
	private List<Operand> getOperands(String formula, Delimiters delimiters) {
		return Arrays.stream(formula.split(delimiters.joining("|")))
				.map(operand -> new Operand(operand))
				.filter(operand -> operand.validate())
				.collect(Collectors.toList());
	}
	
	private String getPureFormula(String formula) {
		Matcher matcher = getMatcherCustomFormula(formula);
		if(matcher.find()) {
			formula = matcher.group(2);
		}
		return formula;
	}
	
	private int sum(List<Operand> operands) {
		return operands.stream()
				.mapToInt(Operand::getOperand)
				.sum();
	}
}