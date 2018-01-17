package com.woowahan.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final List<Integer> BASE_NUMBERS = setBaseNumbers();
    private List<Integer> lotto;

    public Lotto() {
        this.lotto = sort(create());
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    private static List<Integer> setBaseNumbers() {
        List<Integer> baseNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            baseNumbers.add(i);
        }

        return baseNumbers;
    }

    public List<Integer> create() {
        List<Integer> copyBaseList = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(copyBaseList);
        return copyBaseList.subList(0, 6);
    }

    public List<Integer> sort(List<Integer> lotto) {
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        Collections.sort(sortedLotto);

        return sortedLotto;
    }

    public boolean contains(Integer luck) {
        return lotto.contains(luck);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
