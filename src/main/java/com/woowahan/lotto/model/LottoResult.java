package com.woowahan.lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private Map<PriceInfo, Integer> winInfo;

    public LottoResult() {
        this.winInfo = new HashMap<>();

        for (PriceInfo priceInfo : PriceInfo.values()) {
            winInfo.put(priceInfo, 0);
        }
    }

    public void addPriceInfo(PriceInfo info) {
        winInfo.put(info, winInfo.get(info) + 1);
    }

    public int getTotalWinPrice() {
        int totalPrice = 0;
        for (PriceInfo key : winInfo.keySet()) {
            totalPrice += key.calculatePrice(winInfo.get(key));
        }
        return totalPrice;
    }

    public int calculateBenefit(int money) {
        return this.getTotalWinPrice() / (money / 100);
    }

    public TreeMap<PriceInfo, Integer> getSortedWinInfo() {
        winInfo.remove(PriceInfo.LOSE);

        return new TreeMap<>(winInfo);
    }

    public Integer getCount(PriceInfo priceInfo) {
        return winInfo.get(priceInfo);
    }
}
