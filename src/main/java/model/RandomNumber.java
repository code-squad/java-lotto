package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public static List<Integer> shuffleNumber() {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 46; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return getSixNumbers(list);
    }

    private static List<Integer> getSixNumbers(List<Integer> shuffleNumbers) {
        return shuffleNumbers.subList(0,6);
    }
}
