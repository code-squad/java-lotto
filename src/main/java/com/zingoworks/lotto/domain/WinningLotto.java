package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.utils.LottoUtils;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(String lastWinningNumbers, int bonusNumber) {
        this.winningNumbers = LottoUtils.convertToListedNumbers
                (LottoUtils.commaSeparator(lastWinningNumbers));
        this.bonusNumber = bonusNumber;
    }

    List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

}
