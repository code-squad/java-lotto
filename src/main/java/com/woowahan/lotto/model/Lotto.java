package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final List<Integer> BASE_NUMBERS = setBaseNumbers();
    private List<Integer> lotto;

    public Lotto() {
        this.lotto = sort(create());
    }

    public Lotto(List<Integer> lotto) {
        List<Integer> filteredLotto = lotto.stream().distinct().collect(Collectors.toList());

        checkLottoSize(filteredLotto);
        checkBoundsOfNumber(filteredLotto);

        this.lotto = lotto;
    }

    private void checkLottoSize(List<Integer> filteredLotto) {
        if (filteredLotto.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBoundsOfNumber(List<Integer> filteredLotto) {
        filteredLotto.forEach(number -> {
            if (number > 45 || number < 1) throw new IllegalArgumentException();
        });
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
