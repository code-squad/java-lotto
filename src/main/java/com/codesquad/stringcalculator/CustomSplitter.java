package com.codesquad.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    @Override
    public boolean supports(String expression) {
        Matcher m = getMatch(expression);
        return m.find();
    }

    @Override
    public String[] split(String expression) {
        Matcher m = getMatch(expression);
        if(!m.find())
            throw new IllegalArgumentException("지원하지 않는 식입니다.");

        String delimiter = m.group(1);
        String splitExpression = m.group(2);

        if(!splitExpression.matches("^[0-9("+ delimiter +")(:)(\\-)]*$"))
            throw new IllegalArgumentException("잘못된 구분자를 사용한 식입니다.");

        return splitExpression.split(delimiter);
    }

    private Matcher getMatch(String expression) {
        return Pattern.compile("//(.)\n(.*)").matcher(expression);
    }
}