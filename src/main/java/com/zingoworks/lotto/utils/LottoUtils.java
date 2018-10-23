package com.zingoworks.lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtils {
    private static final String COMMA = ",";

    public static List<Integer> getSortedNumbers(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    public static List<Integer> getShuffledNumbers(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    public static String[] commaSeparator(String numbers) {
        return numbers.split(COMMA);
    }

    public static List<Integer> convertToListedNumbers(String[] commaSeparatedNumbers) {
        List<Integer> listedNumbers = new ArrayList<>();
        for (String number : commaSeparatedNumbers) {
            listedNumbers.add(Integer.parseInt(number));
        }
        return listedNumbers;
    }

}
