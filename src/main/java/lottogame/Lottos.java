package lottogame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> get() {
        return lottos;
    }

    public List<Rank> getRanks(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(winningLotto.getMatchCount(lotto), winningLotto.matchBonus(lotto));
            if (rank != null) {
                ranks.add(rank);
            }
        }
        return ranks;
    }
}