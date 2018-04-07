package com.codesquad.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int add(String expression) {

        if (isBlank(expression)) return 0;

        String[] numbers = split(expression);
        return sum(numbers);
    }

    private static boolean isBlank(String expression) {
        if(expression == null)
            return true;

        if(expression.isEmpty())
            return true;
        return false;
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for(String number : numbers) {
            int operand = parseOperand(number);
            validatePositive(operand);
            sum += operand;
        }
        return sum;
    }

    private static void validatePositive(int number) {
        if (number < 0)
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }

    private static int parseOperand(String number) {
        return Integer.parseInt(number);
    }

    private static String[] split(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return expression.split(",|:");
    }

    private static String[] splitOther(String expression) {
        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if(m.find()) {
            delimiter = m.group(1);
            expression = m.group(2);
        }
        return expression.split(delimiter);
    }
}
