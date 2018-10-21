package com.zingoworks.lotto.domain;

import java.util.*;

import static com.zingoworks.lotto.domain.Prize.*;

public class LottoResult {
    private Map<Score, Integer> winningStatus;

    public LottoResult(List<Lotto> lotteries, WinningLotto winningLotto) {
        computeTotalWinningStatus(lotteries, winningLotto);
    }

    public int getCountOfWins(Score score) {
        return winningStatus.get(score);
    }

    public int getNetEarningRate(int purchaseAmount) {
        int earningRate = (computeTotalEarning() - purchaseAmount) / purchaseAmount * 100;
        if (earningRate < 0) {
            return 0;
        }
        return earningRate;
    }

    private int computeTotalEarning() {
        int earn = 0;
        earn += FIRST.getWinningMoney() * getCountOfWins(FIRST.getScore());
        earn += SECOND.getWinningMoney() * getCountOfWins(SECOND.getScore());
        earn += THIRD.getWinningMoney() * getCountOfWins(THIRD.getScore());
        earn += FOURTH.getWinningMoney() * getCountOfWins(FOURTH.getScore());
        earn += FIFTH.getWinningMoney() * getCountOfWins(FIFTH.getScore());

        return earn;
    }

    private void computeTotalWinningStatus(List<Lotto> lotteries, WinningLotto winningLotto) {
        winningStatus = new HashMap<>();
        winningStatus.put(new Score(6, false), 0);
        winningStatus.put(new Score(5, true), 0);
        winningStatus.put(new Score(5, false), 0);
        winningStatus.put(new Score(4, false), 0);
        winningStatus.put(new Score(3, false), 0);
        winningStatus.put(new Score(0, false), 0);

        for (Lotto lottery : lotteries) {
            winningStatus.put(lottery.getScore(winningLotto), winningStatus.get(lottery.getScore(winningLotto)) + 1);
        }
    }
}
