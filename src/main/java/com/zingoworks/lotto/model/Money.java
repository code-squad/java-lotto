package com.zingoworks.lotto.model;

public class Money {
    private static int PRICE_OF_LOTTO = 1000;
    private int purchaseAmount;

    public Money(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int amountToPurchase() {
        return purchaseAmount / PRICE_OF_LOTTO;
    }

    public int getNetEarningRate(int totalEarn) {
        int earningRate = totalEarn / purchaseAmount * 100;
        if (earningRate < 0) {
            return 0;
        }
        return earningRate;
    }
}
