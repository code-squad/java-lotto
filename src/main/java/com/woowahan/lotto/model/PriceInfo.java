package com.woowahan.lotto.model;

import java.util.Arrays;

public enum PriceInfo {
    THREE(3, 5000, false), FOUR(4, 50000, false), FIVE(5, 1500000, false), FIVE_BONUS(5, 30000000, true), SIX(6, 2000000000, false), LOSE(0, 0, false);

    private final int winningCondition;
    private final int price;
    private final boolean bonus;

    private PriceInfo(int winningCondition, int price, boolean bonus) {
        this.winningCondition = winningCondition;
        this.price = price;
        this.bonus = bonus;
    }

    public int getWinningCondition() {
        return winningCondition;
    }

    public int getPrice() {
        return price;
    }

    public static PriceInfo getValueByWinningCondition(int winningCondition, boolean bonus) {
        return Arrays.stream(PriceInfo.values())
                .filter(priceInfo -> checkValue(priceInfo, winningCondition, bonus))
                .findAny()
                .orElse(PriceInfo.LOSE);
    }

    static boolean checkValue(PriceInfo priceInfo, int winningCondition, boolean bonus) {
        if (winningCondition == 5) {
            return priceInfo.winningCondition == winningCondition && priceInfo.bonus == bonus;
        }
        return priceInfo.winningCondition == winningCondition;
    }

    @Override
    public String toString() {
        if (this.equals(FIVE_BONUS)) {
            return this.winningCondition + "개 일치, 보너스 볼 일치(" + this.price + "원)";
        }
        return this.winningCondition + "개 일치(" + this.price + "원)";
    }
}
