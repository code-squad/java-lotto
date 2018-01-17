package com.woowahan.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> baseNumberList;

    public Lotto() {
        baseNumberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            baseNumberList.add(i);
        }
    }
    public List<Integer> create() {
        List<Integer> copyBaseList = new ArrayList<>(baseNumberList);
        Collections.shuffle(copyBaseList);
        return copyBaseList.subList(0, 6);
    }

    public List<List<Integer>> buy(int money) {
        List<List<Integer>> totalLotto = new ArrayList<>();
        for (int i = 0; i < money/1000; i++) {
            totalLotto.add(create());
        }
        return totalLotto;
    }

    public List<Integer> sort(List<Integer> lotto) {
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        Collections.sort(sortedLotto);

        return sortedLotto;
    }
}
