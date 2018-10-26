package com.zingoworks.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Prize, Integer> winningStatus;

    LottoResult() {
        this.winningStatus = defaultWinningStatus();
    }

    public int getTotalWin(Prize prize) {
        return winningStatus.get(prize);
    }

    void addPrize(Prize prize) {
        defaultWinningStatus();

        if(prize != null) {
            winningStatus.put(prize, winningStatus.get(prize) + 1);
        }
    }

    private Map<Prize, Integer> defaultWinningStatus() {
        Map<Prize, Integer> winningStatus = new HashMap<>();
        for (Prize p : Prize.values()) {
            winningStatus.put(p, 0);
        }
        return winningStatus;
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
}