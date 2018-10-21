package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String COMMA = ",";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(String lastWinningNumbers, int bonusNumber) {
        this.winningNumbers = convertToListedNumbers(commaSeparator(lastWinningNumbers));
        this.bonusNumber = bonusNumber;
    }

    List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    private String[] commaSeparator(String numbers) {
        return numbers.split(COMMA);
    }

    private List<Integer> convertToListedNumbers(String[] commaSeparatedNumbers) {
        List<Integer> listedNumbers = new ArrayList<>();
        for (String number : commaSeparatedNumbers) {
            listedNumbers.add(Integer.parseInt(number));
        }
        return listedNumbers;
    }
}
