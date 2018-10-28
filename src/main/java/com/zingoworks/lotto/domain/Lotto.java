package com.zingoworks.lotto.domain;

import java.util.Collections;
import java.util.List;

public abstract class Lotto implements LottosGenerator {
    static final int MINIMUM_RANGE = 1;
    static final int MAXIMUM_RANGE = 45;

    //인스턴스 변수는 private을 구현한다.
    List<Integer> lottoNumbers;

    int getCountOfHit(Lotto winningLotto) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningLotto.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    private static List<Integer> getSortedNumbers(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public String toString() {
        return getSortedNumbers(lottoNumbers).toString();
    }
}
