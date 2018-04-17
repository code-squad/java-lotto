package com.codesquad.stringcalculator;

public class DefaultSplitter implements Splitter {
    final static String DELIMITER = ",|:";

    @Override
    public boolean supports(String expression) {
        return expression.matches("^[0-9(,)(:)(\\-)]*$");
    }

    @Override
    public String[] split(String expression) {
        if(!supports(expression))
            return new String[]{};

        return expression.split(DELIMITER);
    }
}