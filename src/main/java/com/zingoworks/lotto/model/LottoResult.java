package com.zingoworks.lotto.model;

import com.zingoworks.lotto.model.lotto.WinningLotto;
import com.zingoworks.lotto.model.lotto.lottoPack.LottoPack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private Map<Prize, Integer> winStatus;

    public LottoResult(LottoPack lottoPack, WinningLotto winningLotto) {
        this.winStatus = defaultWinStatus();
        updateWinStatus(lottoPack, winningLotto);
    }

    public int getTotalEarning() {
        int totalEarning = 0;
        for (Prize prize : Prize.values()) {
            totalEarning += prize.getEarnedMoney(winStatus.get(prize));
        }
        return totalEarning;
    }

    private Map<Prize, Integer> defaultWinStatus() {
        Map<Prize, Integer> winStatus = new HashMap<>();
        for (Prize p : Prize.values()) {
            winStatus.put(p, 0);
        }
        return winStatus;
    }

    private void updateWinStatus(LottoPack lottoPack, WinningLotto winningLotto) {
        for (Prize prize : lottoPack.generateWinStatus(winningLotto)) {
            Optional.ofNullable(winStatus.put(prize, winStatus.get(prize) + 1))
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    public int getTotalWin(Prize prize) {
        return winStatus.get(prize);
    }
}
