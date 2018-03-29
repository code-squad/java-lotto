package lotto.lotto.domain;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeeklyLotto {

    private List<Integer> winningLotto;

    public WeeklyLotto(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Integer> confirmRank(List<Lotto> lottos) {
        List<Integer> rank = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        for (Lotto one : lottos) {
            Rank value = one.coutOfMatchLotto(winningLotto);
            if (value != null) {
                caseOfRank(value, rank);
            }
        }
        return rank;
    }

    public void caseOfRank(Rank value, List<Integer> rank) {
        switch (value) {
            case FIRST:
                rank.set(0, rank.get(0) + 1);
                break;
            case THIRD:
                rank.set(1, rank.get(1) + 1);
                break;
            case FOURTH:
                rank.set(2, rank.get(2) + 1);
                break;
            case FIFTH:
                rank.set(3, rank.get(3) + 1);
                break;
            default:
                break;
        }
    }
}
