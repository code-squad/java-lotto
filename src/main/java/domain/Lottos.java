package domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Statistic match(Lotto winnerLotto, int bonus) {
        Statistic statistic = new Statistic();
        statistic.initWinnerInfo();
        for (Lotto lotto : lottos) {
            statistic.makeResult(lotto.countMatchedNumber(winnerLotto), lotto.checkBonusNumber(bonus));
        }
        return statistic;
    }

    public int getSize() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
