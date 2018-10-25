package com.zingoworks.lotto.domain;

import java.util.*;

public class LottoResult {
    private Map<Prize, Integer> winningStatus;

    LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.winningStatus = computeTotalWinningStatus(lottos, winningLotto);
    }

    public int getTotalWin(Prize prize) {
        return winningStatus.get(prize);
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

    private Map<Prize, Integer> computeTotalWinningStatus(Lottos lottos, WinningLotto winningLotto) {
        Map<Prize, Integer> status = new HashMap<>();
        for (Prize prize : Prize.values()) {
            status.put(prize, lottos.computeTotalWins(prize, winningLotto));
        }
        return status;
    }
}