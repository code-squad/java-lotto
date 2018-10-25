package domain;

import java.util.List;

public class Lottos {
    private List<Lotto> autoLottos;
    private WinningRules winningRules = new WinningRules();

    private Lottos(List<Lotto> lottos) {
        this.autoLottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public void matchLotto(Lotto winnerLotto) {
        for (Lotto lotto : this.autoLottos) {
           winningRules.increase(winnerLotto.compareLotto(lotto));
        }
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public WinningRules getWinningRules() {
        return winningRules;
    }
}
