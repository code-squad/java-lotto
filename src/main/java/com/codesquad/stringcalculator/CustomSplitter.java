package com.codesquad.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    @Override
    public boolean supports(String expression) {
        Matcher m = getMatch(expression);
        if(!m.find())
            return false;

        String delimiter = m.group(1);
        String splitExpression = m.group(2);
        return splitExpression.matches("^[0-9("+ delimiter +")(:)(\\-)]*$");
    }

    @Override
    public String[] split(String expression) {
        if(!supports(expression))
            return new String[]{};

        Matcher m = getMatch(expression);
        if(!m.find())
            return new String[]{};

        String delimiter = m.group(1);
        String splitExpression = m.group(2);
        return splitExpression.split(delimiter);
    }

    private Matcher getMatch(String expression) {
        return Pattern.compile("//(.)\n(.*)").matcher(expression);
    }
}