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

        money += 2000000000 * winningLottos.get(Rank.FIRST);

        money += 30000000 * winningLottos.get(Rank.SECOND);

        money += 1500000 * winningLottos.get(Rank.THIRD);

        money += 50000 * winningLottos.get(Rank.FOURTH);

        money += 5000 * winningLottos.get(Rank.FIFTH);

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
