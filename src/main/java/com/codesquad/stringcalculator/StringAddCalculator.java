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

        String[] numbers = split(expression);
        return sum(numbers);
    }

    private boolean isBlank(String expression) {
        if(expression == null)
            return true;

        return expression.isEmpty();
    }

    private Positive sum(String[] numbers) {

        return Arrays.stream(numbers)
                .map(Positive::new)
                .reduce(Positive::add)
                .get();
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
        Splitter splitter = findSplitter(expression);
        return splitter.split(expression);
    }

    private Splitter findSplitter(String expression) {
        return splitters.stream()
                .filter(splitter -> splitter.supports(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("분리 가능한 구분자를 식에서 찾을 수 없습니다."));
    }

    private String[] splitWithFor(String expression) {
        for(Splitter splitter : splitters){
            if(splitter.supports(expression))
                return splitter.split(expression);
        }

        throw new IllegalArgumentException("분리 가능한 구분자를 식에서 찾을 수 없습니다.");
    }
}
