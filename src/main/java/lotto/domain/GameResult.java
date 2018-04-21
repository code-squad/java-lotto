package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private Map<Rank, Integer> winningLottos;

    public GameResult() {
        this.winningLottos = new HashMap<>();
        init();
    }

    public void addWinningLotto(Rank rank) {
        this.winningLottos.put(rank, winningLottos.get(rank) + 1);
    }

    public long getEarnedMoney() {
        long money = 0;

        for (Rank rank : Rank.values())
            money += rank.getWinningMoney() * winningLottos.get(rank);

        return money;
    }

    private void init() {
        for (Rank rank : Rank.values())
            winningLottos.put(rank, 0);
    }

    public int getRankedLotto(Rank rank) {
        return winningLottos.get(rank);
    }

}
