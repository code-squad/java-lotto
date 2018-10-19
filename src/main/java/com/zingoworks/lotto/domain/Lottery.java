package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.utils.ListIntegerUtils;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int REGULAR_CHOICE = 6;

    private List<Integer> lotteryNumbers;

    Lottery() {
        this.lotteryNumbers = generateRandomLotteryNumbers();
    }

    public List<Integer> getSortedLotteryNumbers() {
        return ListIntegerUtils.getSortedNumbers(lotteryNumbers);
    }

    List<Integer> generateBasicNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    List<Integer> generateRandomLotteryNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbersToAdd = ListIntegerUtils.getShuffledNumbers(generateBasicNumbers());
        for (int i = 0; i < REGULAR_CHOICE; i++) {
            numbers.add(numbersToAdd.get(i));
        }
        return numbers;
    }
//적중카운트에 대한 테스트는 어떻게 만드는 게 좋은걸까? 접근방식이 잘못...? 랜덤으로 생성되는 것에 대해 테스트 어찌..?
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
