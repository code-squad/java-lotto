package com.codesquad.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static Positive add(String expression) {

        if (isBlank(expression)) return new Positive(0);

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

    private static Positive sum(String[] numbers) {
        Positive sum = new Positive(0);
        for(String number : numbers) {
            Positive operand = new Positive(number);
            sum = sum.add(operand);
        }
        return sum;
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
