package lotto.model;

import java.util.Collections;
import java.util.List;

import lotto.model.MatchingResults.Match;

public class UserLotto {
    public static final int MONEY_PER_TICKET = 1000;
    
    private List<Integer> lotto;

    public UserLotto(List<Integer> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public Match countOfMatch(WinningLotto winningLotto) {
        return winningLotto.countOfMatch(lotto);
    }
    
    @Override
    public String toString() {
        return "Lotto [lotto=" + lotto + "]";
    }
}
