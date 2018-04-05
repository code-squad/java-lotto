package lotto;

import rank.Rank;
import result.Result;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Result match(WinningLotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto: lottos) {
            ranks.add(decision(lotto, winLotto));
        }
        Result result = new Result(ranks);
        return result;
    }

    public Rank decision(Lotto lotto, WinningLotto winLotto) {
        if(lotto.getLotto().contains(winLotto.getBonusNumber()))
            return Rank.valueOf(lotto.countNumber(winLotto.getWinningNumber()), true);
        return Rank.valueOf(lotto.countNumber(winLotto.getWinningNumber()), false);
    }
}
