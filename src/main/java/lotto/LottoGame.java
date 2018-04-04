package lotto;

import rank.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public List<Rank> match(List<Lotto> lottos, Lotto winningNumber, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto: lottos) {
            ranks.add(decision(lotto, winningNumber, bonusNumber));
        }
        return ranks;
    }
    public int getCount(List<Integer> counts, int matchNumber) {
        int numberCount = 0;
        for(int i = 0; i < counts.size(); i++) {
            if(counts.get(i) == matchNumber)
                numberCount++;
        }
        return numberCount;
    }

    public List<Integer> getWinCounts(List<Integer> counts) {
        List<Integer> winCounts = new ArrayList<>();
        for(int i = 3; i < 7; i++)
            winCounts.add(getCount(counts, i));
        return winCounts;
    }

    public Rank decision(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        if(lotto.getLotto().contains(bonusNumber))
            return Rank.valueOf(lotto.countNumber(winningLotto), true);
        return Rank.valueOf(lotto.countNumber(winningLotto), false);
    }
}
