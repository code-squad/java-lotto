package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.utils.ListIntegerUtils;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int REGULAR_CHOICE = 6;

    private List<Integer> lottoNumbers;

    Lotto() {
        this.lottoNumbers = generateRandomLottoNumbers();
    }

    List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> shuffledRandomNumbers = ListIntegerUtils.getShuffledNumbers(BasicNumber.getBasicNumberSet());
        for (int i = 0; i < REGULAR_CHOICE; i++) {
            lottoNumbers.add(shuffledRandomNumbers.get(i));
        }
        return lottoNumbers;
    }

    Score getScore(WinningLotto winningLotto) {
        return new Score(getCountOfHit(winningLotto), isBonusHit(winningLotto));
    }

    private boolean isBonusHit(WinningLotto winningLotto) {
        if (getCountOfHit(winningLotto) == 5) {
            return lottoNumbers.contains(winningLotto.getBonusNumber());
        }
        return false;
    }

    private int getCountOfHit(WinningLotto winningLotto) {
        int count = 0;
        for (Integer winningNumber : winningLotto.getWinningNumbers()) {
            count = increaseCount(count, winningNumber);
        }

        if(count < 3) {
            return 0;
        }

        return count;
    }

    private int increaseCount(int count, Integer winningNumber) {
        if (this.lottoNumbers.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    private String getSortedLottoNumbers() {
        return ListIntegerUtils.getSortedNumbers(lottoNumbers).toString();
    }

    @Override
    public String toString() {
        return getSortedLottoNumbers();
    }
}
