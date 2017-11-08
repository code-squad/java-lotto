package lotto.model;

import java.util.List;

public class Lottos {
    private List<UserLotto> lottos;

    public Lottos(List<UserLotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public MatchingResults match(WinningLotto winningLotto) {
        MatchingResults result = new MatchingResults(lottos.size());
        for (UserLotto userLotto : lottos) {
            result.add(userLotto.countOfMatch(winningLotto));
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "Lottos [lottos=" + lottos + "]";
    }
}
