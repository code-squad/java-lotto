package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BasicNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public static List<Integer> getBasicNumberSet() {
        List<Integer> basicNumbers = new ArrayList<>();
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            basicNumbers.add(i);
        }
        return basicNumbers;
    }
    //클래스분리 필요성...?
}
