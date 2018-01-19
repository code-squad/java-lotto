package com.woowahan.lotto.model;

import java.util.Arrays;

public enum PriceInfo {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), FIVE_BONUS(7, 30000000), SIX(6, 2000000000), LOSE(0, 0);

    private final int winningCondition;
    private final int price;

    PriceInfo(int winningCondition, int price) {
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
                .filter(priceInfo -> checkValue(priceInfo, winningCondition))
                .findAny()
                .orElse(PriceInfo.LOSE);
    }

    static boolean checkValue(PriceInfo priceInfo, int winningCondition) {
        return priceInfo.winningCondition == winningCondition;
    }

    @Override
    public String toString() {
        if (this.equals(FIVE_BONUS)) {
            return FIVE.winningCondition + "개 일치, 보너스 볼 일치(" + this.price + "원)";
        }
        return this.winningCondition + "개 일치(" + this.price + "원)";
    }

    public int calculatePrice(Integer count) {
        return this.price * count;
    }
}
