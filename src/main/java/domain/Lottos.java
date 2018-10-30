package domain;

import java.util.List;

public class Lottos {
    private List<Lotto> Lottos;
    private LottoryManager lottoryManager = new LottoryManager();

    private Lottos(List<Lotto> lottos) {
        this.Lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public void matchLotto(WinnerLotto winnerLotto) {
        for (Lotto lotto : this.Lottos) {
           lottoryManager.increase(winnerLotto.compareLotto(lotto),winnerLotto.compareBonus(lotto));
        }
    }

    public List<Lotto> getLottos() {
        return Lottos;
    }

    public LottoryManager getLottoryManager() {
        return lottoryManager;
    }
}
