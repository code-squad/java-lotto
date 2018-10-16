package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    public static final int PRICE_LOTTERY = 1000;

    private List<Lottery> lotteries;

    private Lotteries(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("<경고> 구매금액은 0원 이상입니다.");
        }
        this.lotteries = generateLotteries(purchaseAmount);
    }

    public static List<Lottery> getAllLotteries(int purchaseAmount) {
        return new Lotteries(purchaseAmount).getLotteries();
    }

    private List<Lottery> getLotteries() {
        return lotteries;
    }

    private List<Lottery> generateLotteries(int purchaseAmount) {
        List<Lottery> allLotteries = new ArrayList<>();
        for (int j = 0; j < purchaseAmount / PRICE_LOTTERY; j++) {
            allLotteries.add(new Lottery());
        }
        return allLotteries;
    }
}
