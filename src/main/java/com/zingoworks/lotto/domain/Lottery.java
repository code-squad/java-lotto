package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.utils.ListIntegerUtils;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    private static final int REGULAR_CHOICE = 6;

    private List<Integer> lotteryNumbers;

    Lottery() {
        this.lotteryNumbers = generateRandomLotteryNumbers();
    }

    public List<Integer> getSortedLotteryNumbers() {
        return ListIntegerUtils.getSortedNumbers(lotteryNumbers);
    }

    List<Integer> generateRandomLotteryNumbers() {
        List<Integer> lotteryNumbers = new ArrayList<>();
        List<Integer> numbersToAdd = ListIntegerUtils.getShuffledNumbers(BasicNumber.getBasicNumberSet());
        for (int i = 0; i < REGULAR_CHOICE; i++) {
            lotteryNumbers.add(numbersToAdd.get(i));
        }
        return lotteryNumbers;
    }

    Score getScore(WinningLottery winningLottery) {
        return new Score(getCountOfHit(winningLottery), isBonusHit(winningLottery));
    }

    boolean isBonusHit(WinningLottery winningLottery) {
        if (getCountOfHit(winningLottery) == 5) {
            return lotteryNumbers.contains(winningLottery.getBonusNumber());
        }
        return false;
    }

    int getCountOfHit(WinningLottery winningLottery) {
        int count = 0;
        for (Integer winningNumber : winningLottery.getWinningNumbers()) {
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
