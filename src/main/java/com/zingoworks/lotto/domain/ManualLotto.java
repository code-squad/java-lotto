package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.SizeOutOfBoundsException;
import com.zingoworks.lotto.util.Parser;

import java.util.List;

class ManualLotto extends Lotto {
    private static final int REGULAR_SIZE = 6;

    ManualLotto(String inputNumbers) {
        lottoNumbers = refineInput(inputNumbers);

        checkValidSize(lottoNumbers.size());
        for (Integer number : lottoNumbers) {
            checkValidRange(number);
        }
    }

    private List<Integer> refineInput(String inputValue) {
        return Parser.arrangeWithNumbers(Parser.commaSeparator(inputValue));
    }

    private void checkValidRange(int number) {
        if(number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException("1~45까지의 숫자 중 선택 가능합니다.");
        }
    }

    private void checkValidSize(int size) {
        if(size != REGULAR_SIZE) {
            throw new SizeOutOfBoundsException("6개의 숫자를 입력하세요.");
        }
    }
}