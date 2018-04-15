package lotto;

import java.util.*;

public class GameResult {

    private Map<Rank, Integer> winningLottos;

    GameResult() {
        winningLottos = new HashMap<>();
        winningLottos.put(Rank.FIRST, 0);
        winningLottos.put(Rank.SECOND, 0);
        winningLottos.put(Rank.THIRD, 0);
        winningLottos.put(Rank.FOURTH, 0);
        winningLottos.put(Rank.FIFTH, 0);
        winningLottos.put(Rank.MISS, 0);
    }

    void accumulateWinLotto(Rank rank) {
        int count = winningLottos.get(rank);
        winningLottos.put(rank, ++count);
    }

    int getRankCount(Rank rank) {
        return winningLottos.get(rank);
    }

}
