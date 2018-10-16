package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    Lotto() {
        this.lottoNumbers = getSortedNumbers(getLottoNumbers());
    }

    List<Integer> getBasicNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbersToAdd = getShuffledNumbers(getBasicNumbers());
        for (int i = 0; i < 6; i++) {
            numbers.add(numbersToAdd.get(i));
        }
        return numbers;
    }

    List<Integer> getSortedNumbers(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    List<Integer> getShuffledNumbers(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    int countMatchingNumbers(List<Integer> lastWinningNumbers) {
        int count = 0;
        for (Integer winningNumber : lastWinningNumbers) {
            count = increaseCount(count, winningNumber);
        }
        return count;
    }

    private int increaseCount(int count, Integer winningNumber) {
        if (this.lottoNumbers.contains(winningNumber)) {
            count++;
        }
        return count;
    }
}
