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

    public Rank decision(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        if(lotto.getLotto().contains(bonusNumber))
            return Rank.valueOf(lotto.countNumber(winningLotto), true);
        return Rank.valueOf(lotto.countNumber(winningLotto), false);
    }
}
