package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class AutomaticLotto extends Lotto {
    private static final List<Integer> BASIC_NUMBERS = getBasicNumbers();
    private static final int AUTO_CHOICE = 6;

    AutomaticLotto() {
        lottoNumbers = getAutomaticLottoNumbers();
    }

    private List<Integer> getAutomaticLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> shuffledNumbers = getShuffledNumbers();
        for (int i = 0; i < AUTO_CHOICE; i++) {
            lottoNumbers.add(shuffledNumbers.get(i));
        }
        return lottoNumbers;
    }

    private List<Integer> getShuffledNumbers() {
        List<Integer> shuffledNumbers = BASIC_NUMBERS;
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }

    private static List<Integer> getBasicNumbers() {
        List<Integer> basicNumbers = new ArrayList<>();
        IntStream.range(MINIMUM_RANGE, MAXIMUM_RANGE + 1).forEach(basicNumbers::add);
        return basicNumbers;
    }
}
