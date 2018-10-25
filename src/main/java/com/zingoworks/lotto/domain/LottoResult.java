package com.zingoworks.lotto.domain;

import java.util.*;

public class LottoResult {
    private Map<Prize, Integer> winningStatus;

    LottoResult() {
        this.winningStatus = defaultWinningStatus();
    }

    public int getTotalWin(Prize prize) {
        return winningStatus.get(prize);
    }

    //if문 없애기 가능?
    public void addPrize(Prize prize) {
        if(prize != null) {
            winningStatus.put(prize, winningStatus.get(prize) + 1);
        }
    }

    public int getNetEarningRate(int purchaseAmount) {
        int earningRate = (getTotalEarning() - purchaseAmount) / purchaseAmount * 100;
        if (earningRate < 0) {
            return 0;
        }
        return earningRate;
    }

    private int getTotalEarning() {
        int totalEarning = 0;
        for (Prize prize : Prize.values()) {
            totalEarning += prize.getEarnedMoney(winningStatus.get(prize));
        }
        return totalEarning;
    }

    private Map<Prize, Integer> defaultWinningStatus() {
        Map<Prize, Integer> status = new HashMap<>();
        for (Prize prize : Prize.values()) {
            status.put(prize, 0);
        }
        return status;
    }
}