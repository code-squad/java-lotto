package com.zingoworks.lotto.utils;

import java.util.Collections;
import java.util.List;

public class ListIntegerUtils {

    public static List<Integer> getSortedNumbers(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    public static List<Integer> getShuffledNumbers(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

}
