package com.codesquad.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StringAddCalculator {
    private List<Splitter> splitters;

    public StringAddCalculator() {
        splitters = new ArrayList<>();
        splitters.add(new DefaultSplitter());
        splitters.add(new CustomSplitter());
    }

    public Positive add(String expression) {

        if (isBlank(expression)) return new Positive(0);

//        String[] numbers = splitWithFor(expression);
        String[] numbers = split(expression);
        return sum(numbers);
    }

    private boolean isBlank(String expression) {
        if(expression == null)
            return true;

        return expression.isEmpty();
    }

    private Positive sum(String[] numbers) {
        Positive sum = Arrays.stream(numbers)
                .map(Positive::new)
                .reduce((leftOperand, rightOperand) -> leftOperand.add(rightOperand))
                .get();

        return sum;
    }

    private Positive sumWithFor(String[] numbers) {
        Positive sum = new Positive(0);
        for(String number : numbers) {
            Positive operand = new Positive(number);
            sum = sum.add(operand);
        }
        return sum;
    }

    private String[] split(String expression) {
        return splitters.stream()
                .filter(splitter -> splitter.supports(expression))
                .findFirst()
                .map(splitter -> splitter.split(expression))
                .get();
    }

    private String[] splitWithFor(String expression) {
        for(Splitter splitter : splitters){
            if(splitter.supports(expression))
                return splitter.split(expression);
        }
        return new String[] { };
    }
}
