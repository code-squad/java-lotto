package com.woowahan.lotto;

import java.util.Arrays;

public enum PriceInfo {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), SIX(6, 2000000000), LOSE(0, 0);

    private final int winningCondition;
    private final int price;

    private PriceInfo(int winningCondition, int price) {
        this.winningCondition = winningCondition;
        this.price = price;
    }

    public int getWinningCondition() {
        return winningCondition;
    }

    public int getPrice() {
        return price;
    }

    public static PriceInfo getValueByWinningCondition(int winningCondition) {
        return Arrays.stream(PriceInfo.values())
                .filter(priceInfo -> priceInfo.winningCondition == winningCondition)
                .findAny()
                .orElse(PriceInfo.LOSE);
    }
}
