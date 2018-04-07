package com.codesquad.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private List<Splitter> splitters;

    public StringAddCalculator() {
        splitters = new ArrayList<>();
        splitters.add(new DefaultSplitter());
        splitters.add(new CustomSplitter());
    }

    public Positive add(String expression) {

        if (isBlank(expression)) return new Positive(0);

        String[] numbers = split(expression);
        return sum(numbers);
    }

    private boolean isBlank(String expression) {
        if(expression == null)
            return true;

        return expression.isEmpty();
    }

    private Positive sum(String[] numbers) {
        Positive sum = new Positive(0);
        for(String number : numbers) {
            Positive operand = new Positive(number);
            sum = sum.add(operand);
        }
        return sum;
    }

    private String[] split(String expression) {
        for(Splitter splitter : splitters){
            if(splitter.supports(expression))
                return splitter.split(expression);
        }
        return new String[] { };
    }
}
