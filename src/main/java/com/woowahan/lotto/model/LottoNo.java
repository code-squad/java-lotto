package com.woowahan.lotto.model;

import java.util.Set;

public class LottoNo implements Comparable<LottoNo> {
    private int number;

    public LottoNo(int number) {
        checkBoundsOfNumber(number);
        this.number = number;
    }

    private void checkBoundsOfNumber(int number) {
        if (number > 45 || number < 1) throw new IllegalArgumentException();
    }

    @Override
    public int compareTo(LottoNo lottoNo) {
        return number - lottoNo.number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
