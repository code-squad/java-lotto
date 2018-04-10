package lotto;

import java.util.*;

public class GameResult {

    private Map<Integer, Integer> winningLottos;

    GameResult() {
        winningLottos = new HashMap<>();
        winningLottos.put(ResultView.THREE_MATCH, 0);
        winningLottos.put(ResultView.FOUR_MATCH, 0);
        winningLottos.put(ResultView.FIVE_MATCH, 0);
        winningLottos.put(ResultView.SIX_MATCH, 0);
    }

    void accumulateWinLottoCount(int matchNumber) {
        if (isWinningNumber(matchNumber)) {
            int count = winningLottos.get(matchNumber);
            winningLottos.put(matchNumber, ++count);
        }
    }

    private boolean isWinningNumber(int matchNumber) {
        return matchNumber >= ResultView.THREE_MATCH
                && matchNumber <= ResultView.SIX_MATCH;
    }

    int getWinningCount(int matchNumber) {
        return this.winningLottos.get(matchNumber);
    }
}
