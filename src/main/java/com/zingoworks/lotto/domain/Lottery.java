package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {
    static final int MIN_RANGE = 1;
    static final int MAX_RANGE = 45;
    static final int REGULAR_CHOICE = 6;

    private List<Integer> lotteryNumbers;

    Lottery() {
        this.lotteryNumbers = getSortedNumbers(getRandomLotteryNumbers());
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    List<Integer> getBasicNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    List<Integer> getRandomLotteryNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbersToAdd = getShuffledNumbers(getBasicNumbers());
        for (int i = 0; i < REGULAR_CHOICE; i++) {
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
        if (this.lotteryNumbers.contains(winningNumber)) {
            count++;
        }
        return count;
    }
}
