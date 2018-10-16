package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE_OF_GAME = 1000;
    public static final String NEWLINE = System.getProperty("line.separator");

    final int MIN_RANGE = 1;
    final int MAX_RANGE = 45;
    final int MAX_REGULAR_NUMBER = 6;

    private List<Integer> lottoNumbers;

    Lotto() {
        this.lottoNumbers = sortNumbers(generateLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    int countWinning(List<Integer> lastWinningNumbers) {
        int count = 0;
        for (Integer integer : lottoNumbers) {
            if (lastWinningNumbers.contains(integer)) {
                count++;
            }
        }
        return count;
    }

    List<Integer> generateLottoNumbers() {
        List<Integer> basicNumbers = getShuffledBasicNumbers();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < MAX_REGULAR_NUMBER; i++) {
            lottoNumbers.add(basicNumbers.get(i));
        }
        return lottoNumbers;
    }

    List<Integer> getShuffledBasicNumbers() {
        List<Integer> numberSet = new ArrayList<>();
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            numberSet.add(i);
        }
        Collections.shuffle(numberSet);
        return numberSet;
    }

    List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
