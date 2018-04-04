package lotto;

import rank.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> match(WinningLotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto: lottos) {
            ranks.add(decision(lotto, winLotto));
        }
        return ranks;
    }

    public Rank decision(Lotto lotto, WinningLotto winLotto) {
        if(lotto.getLotto().contains(winLotto.getBonusNumber()))
            return Rank.valueOf(lotto.countNumber(winLotto.getWinningNumber()), true);
        return Rank.valueOf(lotto.countNumber(winLotto.getWinningNumber()), false);
    }

//    public List<Rank> match(WinningLotto winLotto) {
//        List<Rank> ranks = new ArrayList<>();
//        for (Lotto lotto: lottos) {
//            ranks.add(decision(lotto, winLotto));
//        }
//        return ranks;
//    }

}
