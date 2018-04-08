package LottoGame;

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
        return this.lottos;
    }

    public List<Match> getMatches(WinningLotto winningLotto) {
        List<Match> matches = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Match match = Match.ofMatch(lotto.getMatchCount(winningLotto));
            if (match != null) {
                matches.add(match);
            }
        }
        return matches;
    }

}
