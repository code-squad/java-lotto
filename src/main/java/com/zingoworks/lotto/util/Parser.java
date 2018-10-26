package com.zingoworks.lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";

//    public static String[] lineSeparator(List<String> inputValue) {
//        String[] values = new String[inputValue.size()];
//        for (int i = 0; i < values.length; i++) {
//            values[i] = inputValue.get(i);
//        }
//        return values;
//    }

    public static String[] commaSeparator(String inputValue) {
        return inputValue.split(COMMA);
    }

    public static List<Integer> arrangeWithNumbers(String[] separatedValue) {
        List<Integer> values = new ArrayList<>();
        for (String value : separatedValue) {
            values.add(Integer.parseInt(value));
        }
        return values;
    }
}
