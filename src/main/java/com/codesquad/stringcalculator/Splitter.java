package com.codesquad.stringcalculator;

public interface Splitter {
    boolean supports(String expression);
    String[] split(String expression);
}
