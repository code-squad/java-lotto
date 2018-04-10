package lotto;

import java.util.*;

public class GameResult {
    private static final int FIRST_LOTTO_MATCH_NUMBER = 6;
    private static final int THIRD_LOTTO_MATCH_NUMBER = 5;
    private static final int FOURTH_LOTTO_MATCH_NUMBER = 4;
    private static final int FIFTH_LOTTO_MATCH_NUMBER = 3;

    Map<Integer, List<Lotto>> winLottos;

    GameResult() {
        winLottos = new HashMap<>();
        winLottos.put(FIRST_LOTTO_MATCH_NUMBER, new ArrayList<>());
        winLottos.put(THIRD_LOTTO_MATCH_NUMBER, new ArrayList<>());
        winLottos.put(FOURTH_LOTTO_MATCH_NUMBER, new ArrayList<>());
        winLottos.put(FIFTH_LOTTO_MATCH_NUMBER, new ArrayList<>());
    }

    void saveGameResult(int matchNumber, Lotto lotto) {
        List<Lotto> lottos = winLottos.get(matchNumber);
        lottos.add(lotto);
        winLottos.put(matchNumber, lottos);
    }
}
